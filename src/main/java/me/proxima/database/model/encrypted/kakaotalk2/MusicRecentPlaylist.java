package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedMusicRecentPlaylist;
import me.proxima.database.model.encrypted.Table;


@DatabaseTable(tableName = "music_recent_playlist")
public class MusicRecentPlaylist extends Table<MusicRecentPlaylist, DecryptedMusicRecentPlaylist> {
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

    @Override
    public DecryptedMusicRecentPlaylist decrypt() {
        DecryptedMusicRecentPlaylist dMusicRecentPlaylist = new DecryptedMusicRecentPlaylist();
        dMusicRecentPlaylist.setId_(this.id_);
        dMusicRecentPlaylist.setTitle(this.title);
        dMusicRecentPlaylist.setWriter(this.writer);
        dMusicRecentPlaylist.setThumbnails(this.thumbnails);
        dMusicRecentPlaylist.setSongCount(this.songCount);
        dMusicRecentPlaylist.setSongIds(this.songIds);
        dMusicRecentPlaylist.setCreatedAt(this.createdAt);
        return dMusicRecentPlaylist;
    }
}