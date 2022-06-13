package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "file_path")
public class DecryptedFilePath extends DecryptedTable<DecryptedFilePath> {
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
}
