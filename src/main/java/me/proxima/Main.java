package me.proxima;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Level;
import me.proxima.database.model.encrypted.kakaotalk2.OpenProfile;
import me.proxima.decoder.HexDecoder;
import me.proxima.decoder.KakaoDecryptor;
import me.proxima.preference.SharedPreferenceReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.File;
import java.security.Security;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static void setUserId(){
        Dao<OpenProfile, ?> dao = null;
        try {
            File file = new File("KakaoTalk2.db");

            if(!file.isFile()){
                KakaoDecryptor.Local.userId = new SharedPreferenceReader("KakaoTalk.perferences.xml").getUserId();
                logger.info("LOCAL USER ID = "+ KakaoDecryptor.Local.userId);
                return;
            }

            dao = DaoManager.createDao(new JdbcConnectionSource("jdbc:sqlite:KakaoTalk2.db"), OpenProfile.class);
            List<OpenProfile> profiles = dao.query(dao.queryBuilder().prepare());

            long userId = profiles.get(0).getUserId();

            if(userId > 0L)
                KakaoDecryptor.Local.userId = userId;
            else
                KakaoDecryptor.Local.userId = new SharedPreferenceReader("KakaoTalk.perferences.xml").getUserId();
            logger.info("LOCAL USER ID = "+ KakaoDecryptor.Local.userId);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public static void main(String[] args){
        if(args.length > 0 && args[0].equals("-h")){
            try{
                logger.info("Decrypted Hex string with Key(.kakao.com): "+HexDecoder.decodeHex(args[1]));
            }catch (IndexOutOfBoundsException e){
                logger.error("Please enter a hex string to decrypt!");
                return;
            }
            return;
        }

        com.j256.ormlite.logger.Logger.setGlobalLogLevel(Level.ERROR);
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
        setUserId();

        KakaoDBDecryptor decryptor = new KakaoDBDecryptor();
        decryptor.start();
    }
}
