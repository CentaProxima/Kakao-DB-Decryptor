package me.proxima.database.model.encrypted.kakaotalk;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk.DecryptedWarehouseInfo;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "warehouse_info")
public class WarehouseInfo extends Table<WarehouseInfo, DecryptedWarehouseInfo> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_;

    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String name;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String description;

    @Getter @Setter
    @DatabaseField(columnName = "profile_url", columnDefinition = "TEXT")
    private String profileUrl;

    @Getter @Setter
    @DatabaseField(columnName = "host_id", columnDefinition = "TEXT NOT NULL")
    private String hostId;

    @Getter @Setter
    @DatabaseField(columnName = "accessible_pre_chat", columnDefinition = "INTEGER NOT NULL")
    private Integer accessiblePreChat;

    @Getter @Setter
    @DatabaseField(columnName = "members_invitable", columnDefinition = "INTEGER NOT NULL")
    private Integer membersInvitable;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String status;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer revision;

    @Getter @Setter
    @DatabaseField(columnName = "is_show_welcome", columnDefinition = "INTEGER NOT NULL")
    private Integer isShowWelcome;

    @Getter @Setter
    @DatabaseField(columnName = "accessible_log_id", columnDefinition = "INTEGER NOT NULL")
    private Long accessibleLogId;

    @Getter @Setter
    @DatabaseField(columnName = "user_delete_all_id", columnDefinition = "INTEGER NOT NULL")
    private Long userDeleteAllId;

    @Getter @Setter
    @DatabaseField(columnName = "create_at", columnDefinition = "INTEGER NOT NULL")
    private Long createAt;

    @Override
    public DecryptedWarehouseInfo decrypt() {
        DecryptedWarehouseInfo dWarehouseInfo = new DecryptedWarehouseInfo();
        dWarehouseInfo.setId_(this.id_);
        dWarehouseInfo.setChatId(this.chatId);
        dWarehouseInfo.setName(this.name);
        dWarehouseInfo.setDescription(this.description);
        dWarehouseInfo.setProfileUrl(this.profileUrl);
        dWarehouseInfo.setHostId(this.hostId);
        dWarehouseInfo.setAccessiblePreChat(this.accessiblePreChat);
        dWarehouseInfo.setStatus(this.status);
        dWarehouseInfo.setRevision(this.revision);
        dWarehouseInfo.setIsShowWelcome(this.isShowWelcome);
        dWarehouseInfo.setAccessibleLogId(this.accessibleLogId);
        dWarehouseInfo.setUserDeleteAllId(this.userDeleteAllId);
        dWarehouseInfo.setCreateAt(this.createAt);
        return dWarehouseInfo;
    }
}
