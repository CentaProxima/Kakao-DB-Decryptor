package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedFavoriteEmoticon;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName ="favorite_emoticons")
public class FavoriteEmoticon extends Table<FavoriteEmoticon, DecryptedFavoriteEmoticon> {
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

    @Override
    public DecryptedFavoriteEmoticon decrypt() {
        DecryptedFavoriteEmoticon dFavoriteEmoticon = new DecryptedFavoriteEmoticon();
        dFavoriteEmoticon.setItemId(this.itemId);
        dFavoriteEmoticon.setEmotIdx(this.emotIdx);
        dFavoriteEmoticon.setItemResource(this.itemResource);
        dFavoriteEmoticon.setV(this.v);
        return dFavoriteEmoticon;
    }

}
