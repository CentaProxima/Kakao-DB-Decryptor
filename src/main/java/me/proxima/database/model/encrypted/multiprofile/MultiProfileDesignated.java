package me.proxima.database.model.encrypted.multiprofile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.multiprofile.DecryptedMultiProfileDesignated;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "multi_profile_designated")
public class MultiProfileDesignated extends Table<MultiProfileDesignated, DecryptedMultiProfileDesignated> {
    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL PRIMARY KEY")
    private Long userId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String profileId;

    @Override
    public DecryptedMultiProfileDesignated decrypt() {
        DecryptedMultiProfileDesignated dMultiProfileDesignated = new DecryptedMultiProfileDesignated();
        dMultiProfileDesignated.setUserId(this.userId);
        dMultiProfileDesignated.setProfileId(this.profileId);
        return dMultiProfileDesignated;
    }
}
