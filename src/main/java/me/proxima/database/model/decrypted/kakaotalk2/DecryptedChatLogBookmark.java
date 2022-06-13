package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

public class DecryptedChatLogBookmark extends DecryptedTable<DecryptedChatLogBookmark> {
    @Getter
    @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL PRIMARY KEY")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_log_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatLogId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_message_type", columnDefinition = "INTEGER NOT NULL")
    private Integer chatMessageType;
}
