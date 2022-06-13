package me.proxima;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import me.proxima.database.model.encrypted.AndroidMetadata;
import me.proxima.database.model.encrypted.kakaotalk.*;
import me.proxima.database.model.encrypted.kakaotalk2.*;
import me.proxima.database.model.encrypted.Table;
import me.proxima.database.model.encrypted.multiprofile.MultiProfile;
import me.proxima.database.model.encrypted.multiprofile.MultiProfileDesignated;
import me.proxima.thread.ThreadedKakaoDBDecryptor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KakaoDBDecryptor {
    private final List<Class<? extends Table>> KAKAO_TABLES = new ArrayList<>();
    private final List<Class<? extends Table>> KAKAO2_TABLES = new ArrayList<>();
    private final List<Class<? extends Table>> MULTIPROFILE_TABLES = new ArrayList<>();

    private ConnectionSource KAKAO_SRC;
    private ConnectionSource KAKAO2_SRC;
    private ConnectionSource DKAKAO_SRC;
    private ConnectionSource DKAKAO2_SRC;
    private ConnectionSource MULTIPROFILE_SRC;
    private ConnectionSource DMULTIPROFILE_SRC;

    public KakaoDBDecryptor(){
        try {
            KAKAO_SRC = new JdbcConnectionSource("jdbc:sqlite:KakaoTalk.db");
            KAKAO2_SRC = new JdbcConnectionSource("jdbc:sqlite:KakaoTalk2.db");
            MULTIPROFILE_SRC = new JdbcConnectionSource("jdbc:sqlite:multi_profile_database.db");

            DKAKAO_SRC = new JdbcConnectionSource("jdbc:sqlite:decrypted/KakaoTalk.db");
            DKAKAO2_SRC = new JdbcConnectionSource("jdbc:sqlite:decrypted/KakaoTalk2.db");
            DMULTIPROFILE_SRC = new JdbcConnectionSource("jdbc:sqlite:decrypted/multi_profile_database.db");
            initTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initTables(){
        KAKAO_TABLES.add(AndroidMetadata.class);
        KAKAO_TABLES.add(ChatLog.class);
        KAKAO_TABLES.add(ChatRoom.class);
        KAKAO_TABLES.add(ChatSendingLog.class);
        KAKAO_TABLES.add(PublicKeyInfo.class);
        KAKAO_TABLES.add(SecretKeyInfo.class);
        KAKAO_TABLES.add(WarehouseInfo.class);

        KAKAO2_TABLES.add(AndroidMetadata.class);
        KAKAO2_TABLES.add(BlockFriend.class);
        KAKAO2_TABLES.add(CallLog.class);
        KAKAO2_TABLES.add(ChatLogBookmark.class);
        KAKAO2_TABLES.add(ChatLogBookmark2.class);
        KAKAO2_TABLES.add(ChatLogMeta.class);
        KAKAO2_TABLES.add(ChatLogFavorite.class);
        KAKAO2_TABLES.add(EmoticonKeywordDictionary.class);
        KAKAO2_TABLES.add(FavoriteEmoticon.class);
        KAKAO2_TABLES.add(FilePath.class);
        KAKAO2_TABLES.add(Friend.class);
        KAKAO2_TABLES.add(InappBrowserUrl.class);
        KAKAO2_TABLES.add(Item.class);
        KAKAO2_TABLES.add(ItemResource.class);
        KAKAO2_TABLES.add(KeywordLog.class);
        KAKAO2_TABLES.add(MusicHistory.class);
        KAKAO2_TABLES.add(MusicMediaArchive.class);
        KAKAO2_TABLES.add(MusicPlaylist.class);
        KAKAO2_TABLES.add(MusicRecentPlaylist.class);
        KAKAO2_TABLES.add(OpenLink.class);
        KAKAO2_TABLES.add(OpenProfile.class);
        KAKAO2_TABLES.add(OpenchatBotCommand.class);
        KAKAO2_TABLES.add(OpenlinkPostChatlog.class);
        KAKAO2_TABLES.add(PlusfriendAddInfo.class);
        KAKAO2_TABLES.add(RecentlyEmoticon.class);
        KAKAO2_TABLES.add(S2Event.class);
        KAKAO2_TABLES.add(UrlLog.class);

        MULTIPROFILE_TABLES.add(AndroidMetadata.class);
        MULTIPROFILE_TABLES.add(MultiProfileDesignated.class);
        MULTIPROFILE_TABLES.add(MultiProfile.class);
    }

    public void start(){
        ThreadedKakaoDBDecryptor tkd = new ThreadedKakaoDBDecryptor(
                KAKAO_SRC, "KakaoTalk.db",
                DKAKAO_SRC, "decrypted/KakaoTalk.db",
                KAKAO_TABLES);

        ThreadedKakaoDBDecryptor tkd2 = new ThreadedKakaoDBDecryptor(
                KAKAO2_SRC, "KakaoTalk2.db",
                DKAKAO2_SRC, "decrypted/KakaoTalk2.db",
                KAKAO2_TABLES);

        ThreadedKakaoDBDecryptor tkd3 = new ThreadedKakaoDBDecryptor(
                MULTIPROFILE_SRC, "multi_profile_database.db",
                DMULTIPROFILE_SRC, "decrypted/multi_profile_database.db",
                MULTIPROFILE_TABLES);
        tkd.start();
        tkd2.start();
        tkd3.start();
    }
}