package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedFilePath;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable (tableName = "file_path")
public class FilePath extends Table<FilePath, DecryptedFilePath> {
    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL PRIMARY KEY")
    private String token;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String name;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String path;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    @Override
    public DecryptedFilePath decrypt() {
        DecryptedFilePath dFilePath = new DecryptedFilePath();
        dFilePath.setToken(this.token);
        dFilePath.setName(this.name);
        dFilePath.setPath(this.path);
        dFilePath.setV(this.v);
        return dFilePath;
    }

}
