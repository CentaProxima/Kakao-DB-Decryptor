package me.proxima.database.model.encrypted.kakaotalk;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk.DecryptedSecretKeyInfo;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "secret_key_info")
public class SecretKeyInfo extends Table<SecretKeyInfo, DecryptedSecretKeyInfo> {
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

    @Override
    public DecryptedSecretKeyInfo decrypt() {
        DecryptedSecretKeyInfo dSecretKeyInfo = new DecryptedSecretKeyInfo();
        dSecretKeyInfo.setId_(this.id_);
        dSecretKeyInfo.setChatId(this.chatId);
        dSecretKeyInfo.setSecretKeyToken(this.secretKeyToken);
        dSecretKeyInfo.setSecretKey(this.secretKey);
        dSecretKeyInfo.setCreateAt(this.createAt);
        return dSecretKeyInfo;
    }
}
