package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedEmoticonKeywordDictionary;
import me.proxima.database.model.encrypted.Table;


//completed
@DatabaseTable(tableName = "emoticon_keyword_dictionary")
public class EmoticonKeywordDictionary extends Table<EmoticonKeywordDictionary, DecryptedEmoticonKeywordDictionary> {
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

    @Override
    public DecryptedEmoticonKeywordDictionary decrypt() {
        DecryptedEmoticonKeywordDictionary dEmoticonKeywordDictionary = new DecryptedEmoticonKeywordDictionary();
        dEmoticonKeywordDictionary.setKeywordId(this.keywordId);
        dEmoticonKeywordDictionary.setKeyword(this.keyword);
        dEmoticonKeywordDictionary.setMatchingTexts(this.matchingTexts);
        dEmoticonKeywordDictionary.setHintIcon(this.hintIcon);
        dEmoticonKeywordDictionary.setV(this.v);
        return dEmoticonKeywordDictionary;
    }
}
