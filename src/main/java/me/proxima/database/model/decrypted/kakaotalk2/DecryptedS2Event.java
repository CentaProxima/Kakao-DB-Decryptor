package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "s2_events")
public class DecryptedS2Event extends DecryptedTable<DecryptedS2Event> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String date;

    @Getter @Setter
    @DatabaseField(columnName = "page_id", columnDefinition = "TEXT")
    private String pageId;

    @Getter @Setter
    @DatabaseField(columnName = "action_id", columnDefinition = "INTEGER")
    private Integer actionId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String metadata;

    @Getter @Setter
    @DatabaseField(columnName = "time_stamp", columnDefinition = "INTEGER NOT NULL")
    private Long timeStamp;
}
