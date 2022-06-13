package me.proxima.database.model.decrypted.multiprofile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "multi_profile_designated")
public class DecryptedMultiProfileDesignated extends DecryptedTable<DecryptedMultiProfileDesignated> {
    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL PRIMARY KEY")
    private Long userId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String profileId;
}
