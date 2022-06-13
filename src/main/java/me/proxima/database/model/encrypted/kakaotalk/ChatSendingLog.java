package me.proxima.database.model.encrypted.kakaotalk;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk.DecryptedChatSendingLog;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "chat_sending_logs")
public class ChatSendingLog extends Table<ChatSendingLog, DecryptedChatSendingLog> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer type;

    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String message;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String attachment;

    @Getter @Setter
    @DatabaseField(columnName = "created_at", columnDefinition = "INTEGER")
    private Integer createdAt;

    @Getter @Setter
    @DatabaseField(columnName = "client_message_id", columnDefinition = "INTEGER")
    private Long clientMessageId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String supplement;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    @Override
    public DecryptedChatSendingLog decrypt() {
        DecryptedChatSendingLog dChatSendingLog = new DecryptedChatSendingLog();
        dChatSendingLog.setId_(this.id_);
        dChatSendingLog.setType(this.type);
        dChatSendingLog.setChatId(this.chatId);
        dChatSendingLog.setMessage(this.message);
        dChatSendingLog.setAttachment(this.attachment);
        dChatSendingLog.setCreatedAt(this.createdAt);
        dChatSendingLog.setClientMessageId(this.clientMessageId);
        dChatSendingLog.setSupplement(this.supplement);
        dChatSendingLog.setV(this.v);
        return dChatSendingLog;
    }
}
