package me.proxima.database.model.decrypted.kakaotalk;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "chat_sending_logs")
public class DecryptedChatSendingLog extends DecryptedTable<DecryptedChatSendingLog> {
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
}
