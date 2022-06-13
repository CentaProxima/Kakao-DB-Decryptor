package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "openchat_bot_commmand")
public class DecryptedOpenchatBotCommand extends DecryptedTable<DecryptedOpenchatBotCommand> {
    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL PRIMARY KEY")
    private String id;

    @Getter @Setter
    @DatabaseField(columnName = "bot_id", columnDefinition = "INTEGER NOT NULL")
    private Long botId;

    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "link_id", columnDefinition = "INTEGER NOT NULL")
    private Long linkId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String name;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String description;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Long revision;

    @Getter @Setter
    @DatabaseField(columnName = "updated_at", columnDefinition = "INTEGER NOT NULL")
    private Long updatedAt;
}
