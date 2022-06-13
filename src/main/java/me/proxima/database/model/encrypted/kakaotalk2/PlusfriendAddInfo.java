package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedPlusfriendAddInfo;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "plusfriend_add_info")
public class PlusfriendAddInfo extends Table<PlusfriendAddInfo, DecryptedPlusfriendAddInfo> {
    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT NOT NULL PRIMARY KEY")
    private String uuid;

    @Getter @Setter
    @DatabaseField(columnName = "profile_id", columnDefinition = "TEXT")
    private String profileId;

    @Getter @Setter
    @DatabaseField(columnName = "click_id", columnDefinition = "TEXT")
    private String clickId;

    @Getter @Setter
    @DatabaseField(columnName = "ad_service_id", columnDefinition = "TEXT")
    private String adServiceId;

    @Getter @Setter
    @DatabaseField(columnName = "time_stamp", columnDefinition = "INTEGER NOT NULL")
    private Long timeStamp;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String v;

    @Override
    public DecryptedPlusfriendAddInfo decrypt() {
        DecryptedPlusfriendAddInfo dPlusfriendAddInfo = new DecryptedPlusfriendAddInfo();
        dPlusfriendAddInfo.setUuid(this.uuid);
        dPlusfriendAddInfo.setProfileId(this.profileId);
        dPlusfriendAddInfo.setClickId(this.clickId);
        dPlusfriendAddInfo.setAdServiceId(this.adServiceId);
        dPlusfriendAddInfo.setTimeStamp(this.timeStamp);
        dPlusfriendAddInfo.setV(this.v);
        return dPlusfriendAddInfo;
    }
}
