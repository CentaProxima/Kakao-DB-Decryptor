package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "friends")
public class DecryptedFriend extends DecryptedTable<DecryptedFriend> {
    @Getter @Setter
    @DatabaseField(columnName = "_id", columnDefinition = "INTEGER PRIMARY KEY AUTOINCREMENT")
    private Long id_; //what type

    @Getter @Setter
    @DatabaseField(columnName = "contact_id", columnDefinition = "INTEGER")
    private Long contactId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Long id;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer type;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String uuid;

    @Getter @Setter
    @DatabaseField(columnName = "phone_number", columnDefinition = "TEXT NOT NULL")
    private String phoneNumber;

    @Getter @Setter
    @DatabaseField(columnName = "raw_phone_number", columnDefinition = "TEXT")
    private String rawPhoneNumber;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL")
    private String name;

    @Getter @Setter
    @DatabaseField(columnName = "phonetic_name", columnDefinition = "TEXT")
    private String phoneticName;

    @Getter @Setter
    @DatabaseField(columnName = "profile_image_url", columnDefinition = "TEXT")
    private String profileImageUrl;

    @Getter @Setter
    @DatabaseField(columnName = "full_profile_image_url", columnDefinition = "TEXT")
    private String fullProfileImageUrl;

    @Getter @Setter
    @DatabaseField(columnName = "original_profile_image_url", columnDefinition = "TEXT")
    private String originalProfileImageUrl;

    @Getter @Setter
    @DatabaseField(columnName = "status_message", columnDefinition = "TEXT")
    private String statusMessage;

    @Getter @Setter
    @DatabaseField(columnName = "chat_id", columnDefinition = "INTEGER NOT NULL")
    private Long chatId;

    @Getter @Setter
    @DatabaseField(columnName = "brand_new", columnDefinition = "INTEGER NOT NULL")
    private Integer brandNew;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer blocked;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer favorite;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer position;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    @Getter @Setter
    @DatabaseField(columnName = "board_v", columnDefinition = "TEXT")
    private String boardV;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String ext;

    @Getter @Setter
    @DatabaseField(columnName = "nick_name", columnDefinition = "TEXT")
    private String nickName;

    @Getter @Setter
    @DatabaseField(columnName = "user_type", columnDefinition = "INTEGER NOT NULL")
    private Integer userType;

    @Getter @Setter
    @DatabaseField(columnName = "story_user_id", columnDefinition = "INTEGER")
    private Long storyUserId;

    @Getter @Setter
    @DatabaseField(columnName = "account_id", columnDefinition = "INTEGER")
    private Long accountId;

    @Getter @Setter
    @DatabaseField(columnName = "linked_services", columnDefinition = "TEXT")
    private String linkedServices;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer hidden;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer purged;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer suspended;

    @Getter @Setter
    @DatabaseField(columnName = "member_type", columnDefinition = "INTEGER NOT NULL")
    private Integer memberType;

    @Getter @Setter
    @DatabaseField(columnName = "involved_chat_ids", columnDefinition = "TEXT")
    private String involvedChatIds;

    @Getter @Setter
    @DatabaseField(columnName = "contact_name", columnDefinition = "TEXT")
    private String contactName;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer enc;

    @Getter @Setter
    @DatabaseField(columnName = "created_at", columnDefinition = "INTEGER")
    private Long createdAt;

    @Getter @Setter
    @DatabaseField(columnName = "new_badge_updated_at", columnDefinition = "INTEGER")
    private Long newBadgeUpdatedAt;

    @Getter @Setter
    @DatabaseField(columnName = "new_badge_seen_at", columnDefinition = "INTEGER")
    private Long newBadgeSeenAt;

    @Getter @Setter
    @DatabaseField(columnName = "status_action_token", columnDefinition = "INTEGER")
    private Long statusActionToken;
}
