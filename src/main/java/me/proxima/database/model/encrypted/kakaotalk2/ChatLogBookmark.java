package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedChatLogBookmark;
import me.proxima.database.model.encrypted.Table;

@DatabaseTable(tableName = "chat_log_bookmark")
public class ChatLogBookmark extends Table<ChatLogBookmark, DecryptedChatLogBookmark> {
    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL PRIMARY KEY")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_log_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatLogId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_message_type", columnDefinition = "INTEGER NOT NULL")
    private Integer chatMessageType;

    @Override
    public DecryptedChatLogBookmark decrypt() {
        DecryptedChatLogBookmark dChatLogBookmark = new DecryptedChatLogBookmark();
        dChatLogBookmark.setChatId(this.chatId);
        dChatLogBookmark.setChatLogId(this.chatLogId);
        dChatLogBookmark.setChatMessageType(this.chatMessageType);
        return dChatLogBookmark;
    }
}
