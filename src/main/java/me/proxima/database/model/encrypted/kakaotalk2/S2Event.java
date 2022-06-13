package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedS2Event;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "s2_events")
public class S2Event extends Table<S2Event, DecryptedS2Event> {
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

    @Override
    public DecryptedS2Event decrypt() {
        DecryptedS2Event dS2Event = new DecryptedS2Event();
        dS2Event.setId_(this.id_);
        dS2Event.setDate(this.date);
        dS2Event.setPageId(this.pageId);
        dS2Event.setActionId(this.actionId);
        dS2Event.setMetadata(this.metadata);
        dS2Event.setTimeStamp(this.timeStamp);
        return dS2Event;
    }
}
