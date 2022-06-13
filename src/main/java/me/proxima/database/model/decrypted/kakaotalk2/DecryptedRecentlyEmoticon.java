package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "recently_emoticons")
public class DecryptedRecentlyEmoticon extends DecryptedTable<DecryptedRecentlyEmoticon> {
    @Getter @Setter
    @DatabaseField(columnName = "emoticon_id", columnDefinition = "INTEGER PRIMARY KEY")
    private Long emoticonId;

    @Getter @Setter
    @DatabaseField(columnName = "last_used_at", columnDefinition = "INTEGER")
    private Long lastUsedAt;

    @Getter @Setter
    @DatabaseField(columnName = "count_used", columnDefinition = "INTEGER")
    private Integer countUsed;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    @Getter @Setter
    @DatabaseField(columnName = "item_id", columnDefinition = "TEXT")
    private String itemId;
}
