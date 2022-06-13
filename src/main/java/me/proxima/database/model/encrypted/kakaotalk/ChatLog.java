package me.proxima.database.model.encrypted.kakaotalk;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk.DecryptedChatLog;
import me.proxima.database.model.encrypted.Table;
import me.proxima.decoder.KakaoDecryptor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//completed
@DatabaseTable(tableName = "chat_logs")
public class ChatLog extends Table<ChatLog, DecryptedChatLog> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private long id;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer type;

    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL")
    private long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "user_id", columnDefinition = "INTEGER")
    private Long userId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String message;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String attachment;

    @Getter @Setter
    @DatabaseField(columnName = "created_at", columnDefinition = "INTEGER")
    private Long createdAt;

    @Getter @Setter
    @DatabaseField(columnName = "deleted_at", columnDefinition = "INTEGER")
    private Long deletedAt;

    @Getter @Setter
    @DatabaseField(columnName = "client_message_id", columnDefinition = "INTEGER")
    private Long clientMessageId;

    @Getter @Setter
    @DatabaseField(columnName = "prev_id", columnDefinition = "INTEGER")
    private Long prevId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer referer;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String supplement;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    public DecryptedChatLog decrypt(){
        DecryptedChatLog dChatLog = new DecryptedChatLog();
        dChatLog.setId_(this.id_);
        dChatLog.setId(this.id);
        dChatLog.setType(this.type);
        dChatLog.setChatId(this.chatId);
        dChatLog.setUserId(this.userId);
        dChatLog.setCreatedAt(this.createdAt);
        dChatLog.setDeletedAt(this.deletedAt);
        dChatLog.setClientMessageId(this.clientMessageId);
        dChatLog.setPrevId(this.prevId);
        dChatLog.setReferer(this.referer);
        dChatLog.setV(this.v);

        byte enc = 0;
        try {
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject)parser.parse(this.v);
            if(obj != null && obj.containsKey("enc")){
                String _enc = obj.get("enc").toString();
                enc = Byte.valueOf(_enc); //enc값이 byte값일 경우
                if(_enc.equals("true")) //enc값이 true일 경우
                    enc = 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            enc = 0;
        }

        if(supplement != null && !supplement.isEmpty())
            dChatLog.setSupplement(KakaoDecryptor.decryptString(this.userId, enc, this.supplement));

        dChatLog.setAttachment(attachment);
        if(attachment != null && !attachment.isEmpty() && !attachment.equals("{}"))
            dChatLog.setAttachment(KakaoDecryptor.decryptString(this.userId, enc, this.attachment));

        dChatLog.setMessage(KakaoDecryptor.decryptString(this.userId, enc, this.message));

        return dChatLog;
    }
}
