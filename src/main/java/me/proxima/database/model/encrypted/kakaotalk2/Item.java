package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedItem;
import me.proxima.database.model.encrypted.Table;
import me.proxima.decoder.KakaoDecryptor;

//completed
@DatabaseTable (tableName = "item")
public class Item extends Table<Item, DecryptedItem> {
    @Setter @Getter
    @DatabaseField(columnDefinition = "TEXT NOT NULL PRIMARY KEY")
    private String id;

    @Setter @Getter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer category;

    @Setter @Getter
    @DatabaseField(columnName = "set_order", columnDefinition = "INTEGER")
    private Integer setOrder;

    @Setter @Getter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer enc;

    @Setter @Getter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    @Override
    public DecryptedItem decrypt() {
        DecryptedItem dItem = new DecryptedItem();
        dItem.setId(this.id);
        dItem.setCategory(this.category);
        dItem.setSetOrder(this.setOrder);
        dItem.setEnc(this.enc);
        dItem.setV(KakaoDecryptor.decryptString(KakaoDecryptor.Local.userId, this.enc.byteValue(), this.v));
        return dItem;
    }
}
