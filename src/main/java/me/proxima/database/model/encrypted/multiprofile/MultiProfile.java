package me.proxima.database.model.encrypted.multiprofile;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.multiprofile.DecryptedMultiProfile;
import me.proxima.database.model.encrypted.Table;
import me.proxima.decoder.KakaoDecryptor;

//completed
@DatabaseTable(tableName = "multi_profiles")
public class MultiProfile extends Table<MultiProfile, DecryptedMultiProfile> {
    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL PRIMARY KEY")
    private String profileId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer order;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String nickName;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String profileImageURL;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String fullProfileImageURL;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String originalProfileImageURL;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String statusMessage;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String vBoard;

    @Getter @Setter
    @DatabaseField(columnDefinition = "INTEGER NOT NULL")
    private Integer encryptType;

    @Override
    public DecryptedMultiProfile decrypt() {
        DecryptedMultiProfile dMultiProfile = new DecryptedMultiProfile();
        dMultiProfile.setProfileId(this.profileId);
        dMultiProfile.setOrder(this.order);
        dMultiProfile.setNickName(KakaoDecryptor.decryptString(KakaoDecryptor.Local.userId, encryptType.byteValue(), this.nickName));
        dMultiProfile.setProfileImageURL(KakaoDecryptor.decryptString(KakaoDecryptor.Local.userId, encryptType.byteValue(), this.profileImageURL));
        dMultiProfile.setFullProfileImageURL(KakaoDecryptor.decryptString(KakaoDecryptor.Local.userId, encryptType.byteValue(), this.fullProfileImageURL));
        dMultiProfile.setOriginalProfileImageURL(KakaoDecryptor.decryptString(KakaoDecryptor.Local.userId, encryptType.byteValue(), this.originalProfileImageURL));
        dMultiProfile.setStatusMessage(KakaoDecryptor.decryptString(KakaoDecryptor.Local.userId, encryptType.byteValue(), this.statusMessage));
        dMultiProfile.setVBoard(KakaoDecryptor.decryptString(KakaoDecryptor.Local.userId, encryptType.byteValue(), this.vBoard));
        dMultiProfile.setEncryptType(this.encryptType);
        return dMultiProfile;
    }
}
