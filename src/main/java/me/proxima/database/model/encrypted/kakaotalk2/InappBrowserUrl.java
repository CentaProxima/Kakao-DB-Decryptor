package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedInappBrowserUrl;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable (tableName = "inapp_browser_url")
public class InappBrowserUrl extends Table<InappBrowserUrl, DecryptedInappBrowserUrl> {
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

    @Override
    public DecryptedInappBrowserUrl decrypt() {
        DecryptedInappBrowserUrl dInappBrowserUrl = new DecryptedInappBrowserUrl();
        dInappBrowserUrl.setId_(this.id_);
        dInappBrowserUrl.setTitle(this.title);
        dInappBrowserUrl.setUrl(this.url);
        dInappBrowserUrl.setCreatedAt(this.createdAt);
        dInappBrowserUrl.setV(this.v);
        return dInappBrowserUrl;
    }
}
