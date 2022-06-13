package me.proxima.database.model.decrypted.kakaotalk;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "chat_rooms")
public class DecryptedChatRoom extends DecryptedTable<DecryptedChatRoom> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Long id;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String type;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String members;

    @Getter @Setter
    @DatabaseField(columnName = "active_member_ids", columnDefinition = "TEXT")
    private String activeMemberIds;

    @Getter @Setter
    @DatabaseField(columnName = "last_log_id", columnDefinition = "INTEGER")
    private Long lastLogId;

    @Getter @Setter
    @DatabaseField(columnName = "last_message", columnDefinition = "TEXT")
    private String lastMessage;

    @Getter @Setter
    @DatabaseField(columnName = "last_updated_at", columnDefinition = "INTEGER")
    private Long lastUpdatedAt;

    @Getter @Setter
    @DatabaseField(columnName = "unread_count", columnDefinition = "INTEGER")
    private Integer unreadCount;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String watermarks;

    @Getter @Setter
    @DatabaseField(columnName = "temporary_message", columnDefinition = "TEXT")
    private String temporaryMessage;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String ext;

    @Getter @Setter
    @DatabaseField(columnName = "last_read_log_id", columnDefinition = "INTEGER")
    private Long lastReadLogId;

    @Getter @Setter
    @DatabaseField(columnName = "last_update_seen_id", columnDefinition = "INTEGER")
    private Long lastUpdateSeenId;

    @Getter @Setter
    @DatabaseField(columnName = "active_members_count", columnDefinition = "INTEGER")
    private Integer activeMembersCount;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String meta;

    @Getter @Setter
    @DatabaseField(columnName = "is_hint", columnDefinition = "INTEGER")
    private Boolean hint;

    @Getter @Setter
    @DatabaseField(columnName = "private_meta", columnDefinition = "TEXT")
    private String privateMeta;

    @Getter @Setter
    @DatabaseField(columnName = "last_chat_log_type", columnDefinition = "INTEGER")
    private Integer lastChatLogType;

    @Getter @Setter
    @DatabaseField(columnName = "schat_token", columnDefinition = "INTEGER")
    private Long schatToken;

    @Getter @Setter
    @DatabaseField(columnName = "last_skey_token", columnDefinition = "INTEGER")
    private Long lastSkeyToken;

    @Getter @Setter
    @DatabaseField(columnName = "last_pk_tokens", columnDefinition = "TEXT")
    private String lastPkTokens;

    @Getter @Setter
    @DatabaseField(columnName = "link_id", columnDefinition = "INTEGER")
    private Long linkId;

    @Getter @Setter
    @DatabaseField(columnName = "moim_meta", columnDefinition = "TEXT")
    private String moimMeta;

    @Getter @Setter
    @DatabaseField(columnName = "invite_info", columnDefinition = "TEXT")
    private String inviteInfo;

    @Getter @Setter
    @DatabaseField(columnName = "blinded_member_ids", columnDefinition = "TEXT")
    private String blindedMemberIds;

    @Getter @Setter
    @DatabaseField(columnName = "mute_until_at", columnDefinition = "INTEGER")
    private Long muteUntilAt;

    @Getter @Setter
    @DatabaseField(columnName = "last_joined_log_id", columnDefinition = "INTEGER")
    private Long lastJoinedLogId;
}
