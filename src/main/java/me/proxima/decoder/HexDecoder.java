package me.proxima.decoder;

import org.bouncycastle.util.encoders.Hex;
import java.nio.charset.Charset;

public class HexDecoder {
    private static final byte[] KEY = ".kakao.com".getBytes();

    public static String decodeHex(String encoded){
        byte[] _decoded = new byte[encoded.length()];
        try {
            byte[] _encoded = new String(Hex.decode(encoded), Charset.forName("UTF-8")).getBytes();
            for(int i=0; i<_encoded.length; i++){
                _decoded[i] = (byte)(_encoded[i] ^ KEY[i % KEY.length]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(_decoded, Charset.forName("UTF-8"));
    }
}
