package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedChatLogBookmark2;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "chat_log_bookmarks")
public class ChatLogBookmark2 extends Table<ChatLogBookmark2, DecryptedChatLogBookmark2> {
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


    @Override
    public DecryptedChatLogBookmark2 decrypt() {
        DecryptedChatLogBookmark2 dChatLogBookmark = new DecryptedChatLogBookmark2();
        dChatLogBookmark.setBookmarkId(this.bookmarkId);
        dChatLogBookmark.setChatId(this.chatId);
        dChatLogBookmark.setChatLogId(this.chatLogId);
        dChatLogBookmark.setChatMessageType(this.chatMessageType);
        dChatLogBookmark.setBookmarkMemo(this.bookmarkMemo);
        return dChatLogBookmark;
    }
}
