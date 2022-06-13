package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable (tableName = "item")
public class DecryptedItem extends DecryptedTable<DecryptedItem> {
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
}
