package me.proxima.database.model.encrypted.kakaotalk2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;
import me.proxima.database.model.decrypted.kakaotalk2.DecryptedBlockFriend;
import me.proxima.database.model.encrypted.Table;

//completed
@DatabaseTable(tableName = "block_friends")
public class BlockFriend extends Table<BlockFriend, DecryptedBlockFriend> {
    @Getter @Setter
    @DatabaseField(columnName = "user_id", columnDefinition = "INTEGER NOT NULL PRIMARY KEY")
    private Long userId;

    @Getter @Setter
    @DatabaseField(columnDefinition = "TEXT")
    private String nickname;

    @Getter @Setter
    @DatabaseField(columnName = "profile_image_url", columnDefinition = "TEXT")
    private String profileImageUrl;

    @Getter @Setter
    @DatabaseField(columnName = "block_type", columnDefinition = "INTEGER")
    private Integer blockType;

    @Getter @Setter
    @DatabaseField(columnName = "friend_type", columnDefinition = "INTEGER")
    private Integer friendType;

    @Override
    public DecryptedBlockFriend decrypt() {
        DecryptedBlockFriend dBlockFriend = new DecryptedBlockFriend();
        dBlockFriend.setUserId(this.userId);
        dBlockFriend.setNickname(this.nickname);
        dBlockFriend.setProfileImageUrl(this.profileImageUrl);
        dBlockFriend.setBlockType(this.blockType);
        dBlockFriend.setFriendType(this.friendType);
        return dBlockFriend;
    }
}
