package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable (tableName = "favorite_emoticons")
public class DecryptedFavoriteEmoticon extends DecryptedTable<DecryptedFavoriteEmoticon> {
    @Getter @Setter
    @DatabaseField (columnName = "item_id", columnDefinition = "TEXT NOT NULL PRIMARY KEY")
    private String itemId;

    @Getter @Setter
    @DatabaseField (columnName = "emot_idx", columnDefinition = "INTEGER NOT NULL")
    private Integer emotIdx;

    @Getter @Setter
    @DatabaseField (columnName = "item_resource", columnDefinition = "TEXT")
    private String itemResource;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;
}
