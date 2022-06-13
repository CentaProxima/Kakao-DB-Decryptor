package me.proxima.database.model.decrypted.kakaotalk;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "secret_key_info")
public class DecryptedSecretKeyInfo extends DecryptedTable<DecryptedSecretKeyInfo> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_;

    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "secret_key_token",columnDefinition = "INTEGER NOT NULL")
    private Long secretKeyToken;

    @Getter @Setter
    @DatabaseField(columnName = "secret_key", columnDefinition = "TEXT")
    private String secretKey;

    @Getter @Setter
    @DatabaseField(columnName = "create_at", columnDefinition = "INTEGER")
    private Long createAt;
}
