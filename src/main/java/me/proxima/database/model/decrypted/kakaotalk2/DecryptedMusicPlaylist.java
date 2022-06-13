package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "music_playlist")
public class DecryptedMusicPlaylist extends DecryptedTable<DecryptedMusicPlaylist> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Integer id_;

    @Getter @Setter
    @DatabaseField(columnName = "song_id", columnDefinition = "TEXT NOT NULL")
    private String songId;

    @Getter @Setter
    @DatabaseField(columnName = "song_name", columnDefinition = "TEXT")
    private String songName;

    @Getter @Setter
    @DatabaseField(columnName = "song_url", columnDefinition = "TEXT")
    private String songUrl;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer duration;

    @Getter @Setter
    @DatabaseField(columnName = "album_id", columnDefinition = "TEXT")
    private String albumId;

    @Getter @Setter
    @DatabaseField(columnName = "album_name", columnDefinition = "TEXT")
    private String albumName;

    @Getter @Setter
    @DatabaseField(columnName = "album_url", columnDefinition = "TEXT")
    private String albumUrl;

    @Getter @Setter
    @DatabaseField(columnName = "album_thumbnail_url", columnDefinition = "TEXT")
    private String albumThumbnailUrl;

    @Getter @Setter
    @DatabaseField(columnName = "artist_id", columnDefinition = "TEXT")
    private String artistId;

    @Getter @Setter
    @DatabaseField(columnName = "artist_name", columnDefinition = "TEXT")
    private String artistName;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer adult;

    @Getter @Setter
    @DatabaseField(columnName = "song_cache", columnDefinition = "TEXT")
    private String songCache;

    @Getter @Setter
    @DatabaseField(columnName = "song_file_length", columnDefinition = "INTEGER")
    private Long songFileLength;

    @Getter @Setter
    @DatabaseField(columnName = "song_order", columnDefinition = "INTEGER NOT NULL")
    private Integer songOrder;

    @Getter @Setter
    @DatabaseField(columnName = "create_at", columnDefinition = "INTEGER NOT NULL")
    private Integer createAt;

    @Getter @Setter
    @DatabaseField(columnName = "play_count", columnDefinition = "INTEGER")
    private Integer playCount;

    @Getter @Setter
    @DatabaseField(columnName = "menu_id", columnDefinition = "TEXT")
    private String menuId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;
}
