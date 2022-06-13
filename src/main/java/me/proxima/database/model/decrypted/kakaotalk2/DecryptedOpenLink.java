package me.proxima.database.model.decrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.DecryptedTable;

//completed
@DatabaseTable(tableName = "open_link")
public class DecryptedOpenLink extends DecryptedTable<DecryptedOpenLink> {
    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER PRIMARY KEY")
    private Long id;

    @Getter @Setter
    @DatabaseField(columnName = "user_id", columnDefinition = "INTEGER NOT NULL")
    private Long userId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer token;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String name;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String url;

    @Getter @Setter
    @DatabaseField(columnName = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer type;

    @Getter @Setter
    @DatabaseField(columnName = "member_limit", columnDefinition = "INTEGER")
    private Integer memberLimit;

    @Getter @Setter
    @DatabaseField(columnName = "direct_chat_limit", columnDefinition = "INTEGER")
    private Integer directChatLimit;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer active;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer expired;

    @Getter @Setter
    @DatabaseField(columnName = "created_at", columnDefinition = "INTEGER")
    private Integer createdAt;

    @Getter @Setter
    @DatabaseField(columnName = "view_type", columnDefinition = "INTEGER")
    private Integer viewType;

    @Getter @Setter
    @DatabaseField(columnName = "push_alert", columnDefinition = "INTEGER")
    private Integer pushAlert;

    @Getter @Setter
    @DatabaseField(columnName = "icon_url", columnDefinition = "TEXT")
    private String iconUrl;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer searchable;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String description;
}
