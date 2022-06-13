package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedOpenProfile;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "open_profile")
public class OpenProfile extends Table<OpenProfile, DecryptedOpenProfile> {
    @Getter @Setter
    @DatabaseField(columnName = "link_id", columnDefinition = "INTEGER PRIMARY KEY")
    private Long linkId;

    @Getter @Setter
    @DatabaseField(columnName = "user_id", columnDefinition = "INTEGER NOT NULL")
    private Long userId;

    @Getter @Setter
    @DatabaseField(columnName = "profile_type", columnDefinition = "INTEGER NOT NULL")
    private Integer profileType;

    @Getter @Setter
    @DatabaseField(columnName = "link_member_type", columnDefinition = "INTEGER NOT NULL")
    private Integer linkMemberType;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String nickname;

    @Getter @Setter
    @DatabaseField(columnName = "profile_image_url", columnDefinition = "TEXT")
    private String profileImageUrl;

    @Getter @Setter
    @DatabaseField(columnName = "f_profile_image_url", columnDefinition = "TEXT")
    private String fullProfileImageUrl;

    @Getter @Setter
    @DatabaseField(columnName = "o_profile_image_url", columnDefinition = "TEXT")
    private String originalProfileImageUrl;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Integer token;

    @Getter @Setter
    @DatabaseField(columnName = "profile_link_id", columnDefinition = "INTEGER")
    private Long profileLinkId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER")
    private Long privilege;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    @Override
    public DecryptedOpenProfile decrypt() {
        DecryptedOpenProfile dOpenProfile = new DecryptedOpenProfile();
        dOpenProfile.setLinkId(this.linkId);
        dOpenProfile.setUserId(this.userId);
        dOpenProfile.setProfileType(this.profileType);
        dOpenProfile.setLinkMemberType(this.linkMemberType);
        dOpenProfile.setNickname(this.nickname);
        dOpenProfile.setProfileImageUrl(this.profileImageUrl);
        dOpenProfile.setFullProfileImageUrl(this.fullProfileImageUrl);
        dOpenProfile.setOriginalProfileImageUrl(this.originalProfileImageUrl);
        dOpenProfile.setToken(this.token);
        dOpenProfile.setProfileLinkId(this.profileLinkId);
        dOpenProfile.setPrivilege(this.privilege);
        dOpenProfile.setV(this.v);

        return dOpenProfile;
    }
}
