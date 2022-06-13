package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedMusicMediaArchive;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "music_media_archive")
public class MusicMediaArchive extends Table<MusicMediaArchive, DecryptedMusicMediaArchive> {
    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER PRIMARY KEY")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_room_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatRoomId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer type;

    @Getter @Setter
    @DatabaseField(columnName = "create_at", columnDefinition = "INTEGER NOT NULL")
    private Integer createAt;

    @Getter @Setter
    @DatabaseField(columnName = "content_type", columnDefinition = "TEXT")
    private String contentType;

    @Getter @Setter
    @DatabaseField(columnName = "content_id", columnDefinition = "TEXT")
    private String contentId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String title;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String descirption;

    @Getter @Setter
    @DatabaseField(columnName = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer adult;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String thumbnails;

    @Getter @Setter
    @DatabaseField(columnName = "song_count", columnDefinition = "INTEGER")
    private Integer songCount;

    @Getter @Setter
    @DatabaseField(columnName = "release_date", columnDefinition = "TEXT")
    private String releaseDate;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    @Override
    public DecryptedMusicMediaArchive decrypt() {
        DecryptedMusicMediaArchive dMusicMediaArchive = new DecryptedMusicMediaArchive();
        dMusicMediaArchive.setChatId(this.chatId);
        dMusicMediaArchive.setChatRoomId(this.chatRoomId);
        dMusicMediaArchive.setType(this.type);
        dMusicMediaArchive.setCreateAt(this.createAt);
        dMusicMediaArchive.setContentType(this.contentType);
        dMusicMediaArchive.setContentId(this.contentId);
        dMusicMediaArchive.setTitle(this.title);
        dMusicMediaArchive.setDescirption(this.descirption);
        dMusicMediaArchive.setImageUrl(this.imageUrl);
        dMusicMediaArchive.setAdult(this.adult);
        dMusicMediaArchive.setThumbnails(this.thumbnails);
        dMusicMediaArchive.setSongCount(this.songCount);
        dMusicMediaArchive.setReleaseDate(this.releaseDate);
        dMusicMediaArchive.setV(this.v);
        return dMusicMediaArchive;
    }
}