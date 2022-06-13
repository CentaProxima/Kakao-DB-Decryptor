package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable (tableName = "inapp_browser_url")
public class DecryptedInappBrowserUrl extends DecryptedTable<DecryptedInappBrowserUrl> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String title;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String url;

    @Getter @Setter
    @DatabaseField(columnName = "created_at", columnDefinition = "INTEGER")
    private Long createdAt;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;
}
