package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "call_log")
public class DecryptedCallLog extends DecryptedTable<DecryptedCallLog> {
    @Getter @Setter
    @DatabaseField(columnName = "call_log_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL")
    private Long callLogId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_room_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatRoomId;

    @Getter @Setter
    @DatabaseField(columnName = "call_nested_count", columnDefinition = "INTEGER NOT NULL")
    private Integer callNestedCount;

    @Getter @Setter
    @DatabaseField(columnName = "last_call_type", columnDefinition = "TEXT NOT NULL")
    private String lastCallType;

    @Getter @Setter
    @DatabaseField(columnName = "is_my_chat_log", columnDefinition = "INTEGER NOT NULL")
    private Integer isMyChatLog;

    @Getter @Setter
    @DatabaseField(columnName = "last_call_time", columnDefinition = "INTEGER NOT NULL")
    private Long lastCallTime;
}
