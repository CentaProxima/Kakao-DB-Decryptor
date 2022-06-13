package me.proxima.database.model.encrypted;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedAndroidMetadata;

//completed
@DatabaseTable(tableName = "android_metadata")
public class AndroidMetadata extends Table<AndroidMetadata, DecryptedAndroidMetadata>{
    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String locale;

    @Override
    public DecryptedAndroidMetadata decrypt() {
        DecryptedAndroidMetadata dAndroidMeta = new DecryptedAndroidMetadata();
        dAndroidMeta.setLocale(this.locale);
        return dAndroidMeta;
    }
}
