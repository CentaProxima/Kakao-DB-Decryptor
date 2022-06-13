package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedChatLogFavorite;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "chat_logs_favorite")
public class ChatLogFavorite extends Table<ChatLogFavorite, DecryptedChatLogFavorite> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Long id;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer type;

    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "user_id", columnDefinition = "INTEGER")
    private Long userId;

    @Getter @Setter
    @DatabaseField(columnName = "created_at", columnDefinition = "INTEGER")
    private Long createdAt;


    @Override
    public DecryptedChatLogFavorite decrypt() {
        DecryptedChatLogFavorite dChatLogFavorite = new DecryptedChatLogFavorite();
        dChatLogFavorite.setId_(this.id_);
        dChatLogFavorite.setId(this.id);
        dChatLogFavorite.setType(this.type);
        dChatLogFavorite.setChatId(this.chatId);
        dChatLogFavorite.setUserId(this.userId);
        dChatLogFavorite.setCreatedAt(this.createdAt);
        return dChatLogFavorite;
    }
}
