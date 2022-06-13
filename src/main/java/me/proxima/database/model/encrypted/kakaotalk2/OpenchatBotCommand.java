package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedOpenchatBotCommand;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "openchat_bot_command")
public class OpenchatBotCommand extends Table<OpenchatBotCommand, DecryptedOpenchatBotCommand> {
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

    @Override
    public DecryptedOpenchatBotCommand decrypt() {
        DecryptedOpenchatBotCommand dOpenchatBotCommand = new DecryptedOpenchatBotCommand();
        dOpenchatBotCommand.setId(this.id);
        dOpenchatBotCommand.setBotId(this.botId);
        dOpenchatBotCommand.setChatId(this.chatId);
        dOpenchatBotCommand.setLinkId(this.linkId);
        dOpenchatBotCommand.setName(this.name);
        dOpenchatBotCommand.setDescription(this.description);
        dOpenchatBotCommand.setRevision(this.revision);
        dOpenchatBotCommand.setUpdatedAt(this.updatedAt);
        return dOpenchatBotCommand;
    }
}
