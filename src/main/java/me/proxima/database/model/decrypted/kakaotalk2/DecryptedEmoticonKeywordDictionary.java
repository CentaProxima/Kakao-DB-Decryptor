package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "emoticon_keyword_dictionary")
public class DecryptedEmoticonKeywordDictionary extends DecryptedTable<DecryptedEmoticonKeywordDictionary> {
    @Getter @Setter
    @DatabaseField(columnName = "keyword_id", columnDefinition = "INTEGER NOT NULL PRIMARY KEY")
    private Integer keywordId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String keyword;

    @Getter @Setter
    @DatabaseField(columnName = "matching_texts", columnDefinition = "TEXT NOT NULL")
    private String matchingTexts;

    @Getter @Setter
    @DatabaseField(columnName = "hint_icon", columnDefinition = "TEXT")
    private String hintIcon;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;
}
