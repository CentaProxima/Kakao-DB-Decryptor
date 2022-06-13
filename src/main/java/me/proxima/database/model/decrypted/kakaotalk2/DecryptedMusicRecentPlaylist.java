package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

@DatabaseTable(tableName = "music_recent_playlist")
public class DecryptedMusicRecentPlaylist extends DecryptedTable<DecryptedMusicRecentPlaylist> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL")
    private Long id_;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String title;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String writer;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String thumbnails;

    @Getter @Setter
    @DatabaseField(columnName = "song_count", columnDefinition = "INTEGER NOT NULL")
    private Integer songCount;

    @Getter @Setter
    @DatabaseField(columnName = "song_ids", columnDefinition = "TEXT NOT NULL")
    private String songIds;

    @Getter @Setter
    @DatabaseField(columnName = "created_at", columnDefinition = "INTEGER NOT NULL")
    private Long createdAt;
}
