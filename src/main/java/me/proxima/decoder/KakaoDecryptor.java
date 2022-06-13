package me.proxima.decoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class KakaoDecryptor{
    public static class Local {
        public static long userId = 0L;
    }

    static class MessageInfo{
        public long userId = 0L;
        public byte enc = 0;
    }

    private final char[] KEY = {0x16, 0x08, 0x09, 0x6F, 0x02, 0x17, 0x2B, 0x08, 0x21, 0x21, 0x0A, 0x10, 0x03, 0x03, 0x07, 0x06};
    private final String[] SALT = {
            "", "", "12", "24", "18", "30", "36", "12", "48", "7",
            "35", "40", "17", "23", "29", "isabel", "kale", "sulli", "van", "merry",
            "kyle", "james", "maddux", "tony", "hayden", "paul", "elijah", "dorothy", "sally", "bran", "extr.ursra"
    };
    private final IvParameterSpec IV = new IvParameterSpec(new byte[]{0x0F, 0x08, 0x01, 0x00, 0x19, 0x47, 0x25, -0x24, 0x15, -0x0B, 0x17, -0x20, -0x1F, 0x15, 0x0C, 0x35});

    private Cipher decryptor = null;
    private SecretKeySpec secretKey = null;

    /*
    generate salt by `userId` and `enc`
     */
    private byte[] generateSalt(MessageInfo info){
        byte[] result = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String salt = String.valueOf(info.userId);
        if(info.enc < SALT.length)
            salt = SALT[info.enc] + info.userId;

        byte[] b_salt = salt.getBytes(Charset.forName("UTF-8"));
        System.arraycopy(b_salt, 0, result, 0, b_salt.length <= 16 ? b_salt.length : 16);
        return result;
    }

    /*
    initalize SecretKey with PBEKey
     */
    private void initSecretKey(MessageInfo info){
        if(this.secretKey != null)
            return;

        SecretKey key = null;
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC");
            PBEKeySpec keySpec = new PBEKeySpec(KEY, generateSalt(info), 2, 256);
            key = factory.generateSecret(keySpec);
            this.secretKey = new SecretKeySpec(key.getEncoded(), "AES");
        } catch (Exception e) {
            return;
        }
    }

    private void initDecryptor(MessageInfo info) throws
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if(decryptor != null)
            return;

        initSecretKey(info);
        this.decryptor = Cipher.getInstance("AES/CBC/PKCS5Padding");
        if(secretKey == null)
            throw new NullPointerException("secretKey is null");
        this.decryptor.init(Cipher.DECRYPT_MODE, secretKey, IV);
    }

    private byte[] _decrypt(String encrypted){
        if(decryptor == null)
            return null;

        byte[] decrypted = null;
        try{
            byte[] b_decrypted = Base64.getDecoder().decode(encrypted);
            decrypted = decryptor.doFinal(b_decrypted);
        }catch(Exception e){
            return null;
        }

        return decrypted;
    }

    public static byte[] decrypt(long userId, byte enc, String encrypted) {
        MessageInfo info = new MessageInfo();
        info.userId = userId;
        info.enc = enc;

        byte[] result = null;

        try{
            KakaoDecryptor _decryptor = new KakaoDecryptor();
            _decryptor.initDecryptor(info);
            result = _decryptor._decrypt(encrypted);
        } catch(Exception e){
            result = encrypted.getBytes();
        }
        return result;
    }

    public static String decryptString(long userId, byte enc, String encrypted){
        try {
            byte[] decrypted = decrypt(userId, enc, encrypted);
            return decrypted != null ? new String(decrypted, Charset.forName("UTF-8")) : null;
        }catch(Exception e){
            return encrypted;
        }
    }
}
