package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedUrlLog;
import me.proxima.database.model.encrypted.Table;
//completed
@DatabaseTable(tableName = "url_log")
public class UrlLog extends Table<UrlLog, DecryptedUrlLog> {
    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER PRIMARY KEY")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_room_id", columnDefinition = "INTEGER")
    private Long chatRoomId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer type;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String url;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String title;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String description;

    @Getter @Setter
    @DatabaseField(columnName = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

    @Getter @Setter
    @DatabaseField(columnName = "created_at", columnDefinition = "INTEGER")
    private Integer createdAt;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer suspected;

    @Getter @Setter
    @DatabaseField(columnName = "user_id", columnDefinition = "INTEGER")
    private Long userId;

    @Getter @Setter
    @DatabaseField(columnName = "scrap_status", columnDefinition = "INTEGER")
    private Integer scrapStatus;

    @Override
    public DecryptedUrlLog decrypt() {
        DecryptedUrlLog dUrlLog = new DecryptedUrlLog();
        dUrlLog.setChatId(this.chatId);
        dUrlLog.setChatRoomId(this.chatRoomId);
        dUrlLog.setType(this.type);
        dUrlLog.setUrl(this.url);
        dUrlLog.setTitle(this.title);
        dUrlLog.setDescription(this.description);
        dUrlLog.setImageUrl(this.imageUrl);
        dUrlLog.setCreatedAt(this.createdAt);
        dUrlLog.setSuspected(this.suspected);
        dUrlLog.setUserId(this.userId);
        dUrlLog.setScrapStatus(this.scrapStatus);
        return dUrlLog;
    }
}
