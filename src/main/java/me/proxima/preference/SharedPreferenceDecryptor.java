package me.proxima.preference;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.util.Base64;

public class SharedPreferenceDecryptor {
    private final byte[] KEY = {(byte)12, (byte)10, (byte)-8, (byte)-43, (byte)-12, (byte)44, (byte)5, (byte)-8, (byte)-32, (byte)7, (byte)34, (byte)-24, (byte)-2, (byte)3, (byte)33, (byte)-33};
    private final char[] KEY2 = {(char)42, (char)10, (char)8, (char)120, (char)7, (char)55, (char)11, (char)33, (char)9, (char)33, (char)10, (char)13, (char)5, (char)2, (char)10, (char)7};
    private final byte[] IV = {(byte)10, (byte)2, (byte)3, (byte)-4, (byte)20, (byte)73, (byte)47, (byte)-38, (byte)27, (byte)-22, (byte)11, (byte)-20, (byte)-22, (byte)37, (byte)36, (byte)54};

    private Cipher decryptor;

    public SharedPreferenceDecryptor(){
        try {
            this.decryptor = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(
                    SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC")
                            .generateSecret(new PBEKeySpec(KEY2, KEY, 2, 256))
                            .getEncoded(), "AES");
            this.decryptor.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(IV));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String _decrypt(String key){
        try {
            byte[] doFinal = decryptor.doFinal(Base64.getDecoder().decode(key));
            return new String(
                    doFinal,
                    Charset.forName("UTF-8")
            );
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String decrypt(String key){
        return _decrypt(key);
    }
}
