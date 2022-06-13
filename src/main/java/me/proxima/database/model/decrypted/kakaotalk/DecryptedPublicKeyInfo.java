package me.proxima.database.model.decrypted.kakaotalk;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "public_key_info")
public class DecryptedPublicKeyInfo extends DecryptedTable<DecryptedPublicKeyInfo> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_;

    @Getter @Setter
    @DatabaseField(columnName = "user_id", columnDefinition = "INTEGER NOT NULL")
    private Long userId;

    @Getter @Setter
    @DatabaseField(columnName = "pub_key_token", columnDefinition = "INTEGER NOT NULL")
    private Long pubKeyToken;

    @Getter @Setter
    @DatabaseField(columnName = "encrypt_key", columnDefinition = "TEXT")
    private String encryptKey;

    @Getter @Setter
    @DatabaseField(columnName = "sign_key", columnDefinition = "TEXT")
    private String signKey;

    @Getter @Setter
    @DatabaseField(columnName = "chain_sign", columnDefinition = "TEXT")
    private String chainSign;

    @Getter @Setter
    @DatabaseField(columnName = "create_at", columnDefinition = "INTEGER")
    private Long createAt;

    @Getter @Setter
    @DatabaseField(columnName = "pk_set_token", columnDefinition = "INTEGER NOT NULL")
    private Long pkSetToken;
}
