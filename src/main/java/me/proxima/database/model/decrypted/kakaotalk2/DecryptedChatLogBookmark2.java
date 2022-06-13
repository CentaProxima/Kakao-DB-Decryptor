package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "chat_log_bookmarks")
public class DecryptedChatLogBookmark2 extends DecryptedTable<DecryptedChatLogBookmark2> {
    @Getter @Setter
    @DatabaseField(columnName = "bookmark_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL")
    private Long bookmarkId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_log_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatLogId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_message_type", columnDefinition = "INTEGER NOT NULL")
    private Integer chatMessageType;

    @Getter @Setter
    @DatabaseField(columnName = "bookmark_memo", columnDefinition = "TEXT")
    private String bookmarkMemo;
}
