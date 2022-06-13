package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedItemResource;
import me.proxima.database.model.encrypted.Table;
import me.proxima.decoder.KakaoDecryptor;

//completed
@DatabaseTable (tableName = "item_resource")
public class ItemResource extends Table<ItemResource, DecryptedItemResource> {
    @Setter @Getter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_;

    @Setter @Getter
    @DatabaseField(columnName = "item_category", columnDefinition = "INTEGER NOT NULL")
    private Integer itemCategory;

    @Setter @Getter
    @DatabaseField (columnName = "item_id", columnDefinition = "TEXT NOT NULL")
    private String itemId;

    @Setter @Getter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer enc;

    @Setter @Getter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    @Override
    public DecryptedItemResource decrypt() {
        DecryptedItemResource dItemResource = new DecryptedItemResource();
        dItemResource.setId_(this.id_);
        dItemResource.setItemCategory(this.itemCategory);
        dItemResource.setItemId(this.itemId);
        dItemResource.setEnc(this.enc);
        dItemResource.setV(KakaoDecryptor.decryptString(KakaoDecryptor.Local.userId, this.enc.byteValue(), this.v));
        return dItemResource;
    }
}
