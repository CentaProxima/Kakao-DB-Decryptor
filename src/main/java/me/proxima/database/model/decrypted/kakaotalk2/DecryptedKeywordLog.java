package me.proxima.database.model.decrypted.kakaotalk2;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "keyword_log")
public class DecryptedKeywordLog extends DecryptedTable<DecryptedKeywordLog> {
    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL PRIMARY KEY")
    private Long id;

    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "created_at", columnDefinition = "INTEGER NOT NULL")
    private Integer createdAt;

    @Getter @Setter
    @DatabaseField(columnName = "protected", columnDefinition = "INTEGER NOT NULL")
    private Integer Protected;
}