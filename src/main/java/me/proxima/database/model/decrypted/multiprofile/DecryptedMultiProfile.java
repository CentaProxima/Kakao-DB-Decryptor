package me.proxima.database.model.decrypted.multiprofile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "multi_profiles")
public class DecryptedMultiProfile extends DecryptedTable<DecryptedMultiProfile> {
    @Getter
    @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL PRIMARY KEY")
    private String profileId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer order;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String nickName;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String profileImageURL;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String fullProfileImageURL;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String originalProfileImageURL;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String statusMessage;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String vBoard;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer encryptType;
}
