package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedOpenlinkPostChatlog;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "openlink_post_chatlog")
public class OpenlinkPostChatlog extends Table<OpenlinkPostChatlog, DecryptedOpenlinkPostChatlog> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Long id;

    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "created_at", columnDefinition = "INTEGER")
    private Long createdAt;

    @Getter @Setter
    @DatabaseField(columnName = "deleted_at", columnDefinition = "INTEGER")
    private Long deletedAt;

    @Override
    public DecryptedOpenlinkPostChatlog decrypt() {
        DecryptedOpenlinkPostChatlog dOpenlinkPostChatlog = new DecryptedOpenlinkPostChatlog();
        dOpenlinkPostChatlog.setId_(this.id_);
        dOpenlinkPostChatlog.setId(this.id);
        dOpenlinkPostChatlog.setChatId(this.chatId);
        dOpenlinkPostChatlog.setCreatedAt(this.createdAt);
        dOpenlinkPostChatlog.setDeletedAt(this.deletedAt);
        return dOpenlinkPostChatlog;
    }
}
