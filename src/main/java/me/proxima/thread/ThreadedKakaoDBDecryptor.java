package me.proxima.thread;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;
import me.proxima.database.model.decrypted.DecryptedTable;
import me.proxima.database.model.encrypted.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.util.encoders.Hex;
import org.sqlite.SQLiteErrorCode;
import org.sqlite.SQLiteException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class ThreadedKakaoDBDecryptor extends Thread{
    private static final Logger logger = LogManager.getLogger(ThreadedKakaoDBDecryptor.class);

    private final ConnectionSource KAKAO_SRC;
    private final ConnectionSource DKAKAO_SRC;

    private final File KAKAO_DB_FILE;
    private final File DKAKAO_DB_FILE;
    private final List<Class<? extends Table>> TABLES;

    public ThreadedKakaoDBDecryptor(ConnectionSource source, String dbPath, ConnectionSource dsource, String decryptedDbPath, List<Class<? extends Table>> tables) {
        this.KAKAO_SRC = source;
        this.KAKAO_DB_FILE = new File(dbPath);
        this.DKAKAO_SRC = dsource;
        this.DKAKAO_DB_FILE = new File(decryptedDbPath);
        this.TABLES = tables;
    }

    @Override
    public void run() {
        if(!KAKAO_DB_FILE.isFile())
            return;

        if(!DKAKAO_DB_FILE.getParentFile().isDirectory())
            DKAKAO_DB_FILE.getParentFile().mkdirs();

        DKAKAO_DB_FILE.delete();
        for(Class<? extends Table> _table : TABLES){
            Class<? extends Table> cls = _table;

            try{
                Table table = cls.getDeclaredConstructor().newInstance();
                Dao<Table, ?> dao = table.getDao(KAKAO_SRC);

                QueryBuilder<Table, ?> qb = dao.queryBuilder();
                List<Table> rows = dao.query(qb.prepare());

                TableUtils.dropTable(DKAKAO_SRC, table.getDecryptedType(), true);
                TableUtils.createTable(DKAKAO_SRC, table.getDecryptedType());

                for(Table row : rows){
                    DecryptedTable dtable = row.decrypt();
                    if(dtable == null)
                        continue;
                    dtable.appendRow(DKAKAO_SRC);
                }

                KAKAO_SRC.close();
            }catch (SQLiteException e){
                if(e.getResultCode() == SQLiteErrorCode.SQLITE_ERROR &&
                        e.getMessage().contains("")){
                    DatabaseTable annotation = _table.getDeclaredAnnotation(DatabaseTable.class);
                    logger.error("table "+annotation.tableName()+" cannot be found.");
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        StringBuilder log = new StringBuilder();

        String origin_sha_hash = computeHash(KAKAO_DB_FILE, "SHA-256");
        String new_sha_hash = computeHash(DKAKAO_DB_FILE, "SHA-256");
        String origin_md5_hash = computeHash(KAKAO_DB_FILE, "MD5");
        String new_md5_hash = computeHash(DKAKAO_DB_FILE, "MD5");

        long ksize = KAKAO_DB_FILE.length()/1024; //KB
        long dsize = DKAKAO_DB_FILE.length()/1024; //KB

        log.append("\n\t"+KAKAO_DB_FILE.getAbsolutePath()+": \n");
        log.append("\t\tSize: "+ksize+"KB\n");
        log.append("\t\tSHA-256: "+origin_sha_hash+"\n");
        log.append("\t\tMD-5: "+origin_md5_hash+"\n");

        log.append("\n\t"+DKAKAO_DB_FILE.getAbsolutePath()+": \n");
        log.append("\t\tSize: "+dsize+"KB\n");
        log.append("\t\tSHA-256: "+new_sha_hash+"\n");
        log.append("\t\tMD-5: "+new_md5_hash);

        logger.info(log.toString());
    }

    private byte[] readFile(File file){
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.lines().forEach((line) -> {
                builder.append(line);
            });
        } catch (FileNotFoundException e) {
        }
        return builder.toString().getBytes(StandardCharsets.UTF_8);
    }

    private String computeHash(File file, String algo){
        String hash = null;
        try {
            MessageDigest digest = MessageDigest.getInstance(algo);
            byte[] _hash = Hex.encode(digest.digest(readFile(file)));
            hash = new String(_hash);
        } catch (NoSuchAlgorithmException e) {
            hash = null;
        }
        return hash;
    }
}
