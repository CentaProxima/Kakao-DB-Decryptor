package me.proxima.database.model.decrypted;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;

//completed
@DatabaseTable(tableName = "android_metadata")
public class DecryptedAndroidMetadata extends DecryptedTable<DecryptedAndroidMetadata> {
    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String locale;
}
