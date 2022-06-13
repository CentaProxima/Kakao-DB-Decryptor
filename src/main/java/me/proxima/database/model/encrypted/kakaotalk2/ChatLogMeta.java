package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedChatLogMeta;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "chat_log_meta")
public class ChatLogMeta extends Table<ChatLogMeta, DecryptedChatLogMeta> {
    @Getter @Setter
    @DatabaseField(columnName = "log_id", columnDefinition = "INTEGER NOT NULL PRIMARY KEY")
    private Long logId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "link_id", columnDefinition = "INTEGER NOT NULL")
    private Long linkId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String content;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Long revision;

    @Override
    public DecryptedChatLogMeta decrypt() {
        DecryptedChatLogMeta dChatLogMeta = new DecryptedChatLogMeta();
        dChatLogMeta.setLogId(this.logId);
        dChatLogMeta.setChatId(this.chatId);
        dChatLogMeta.setLinkId(this.linkId);
        dChatLogMeta.setContent(this.content);
        dChatLogMeta.setRevision(this.revision);
        return dChatLogMeta;
    }
}
