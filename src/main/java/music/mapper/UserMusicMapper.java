package music.mapper;

import music.entity.UserMusic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jh_wu
 * @ClassName UserMusicMapper
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
public interface UserMusicMapper {

    /**
     *
     * @param userMusic
     */
    @Insert("INSERT IGNORE INTO\n" +
            "t_user_music(music_id,user_id)\n" +
            "VALUES (#{musicId},#{userId})")
    void likeMusic(UserMusic userMusic);
    /**
     * 批量删除
     * @param idList
     * @return
     */
    @Delete("<script>" +
            "DELETE FROM t_user_music WHERE music_id IN" +
            "<foreach collection=\"idList\" index=\"index\" item=\"item\" open=\"(\" separator=\",\" close=\")\">" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    int batchDelete(@Param("idList") List<Integer> idList);
    /**
     * 批量插入
     * @param userMusics
     * @return int
     */
    @Insert("<script>" +
            "INSERT INTO t_user_music VALUES" +
            "<foreach collection=\"userMusics\" item=\"item\" index=\"index\" separator=\",\">" +
            "(#{item.id},#{item.musicId},#{item.userId})" +
            "</foreach>" +
            "</script>")
    int batchInsert(@Param("userMusics") List<UserMusic> userMusics);

    /**
     * 查重
     * @param userId musicId
     * @return re
     */
    @Select("SELECT * FROM t_user_music WHERE user_id = #{userId} OR music_id = #{musicId}")
    UserMusic re(@Param("userId") Integer userId, @Param("musicId") Integer musicId);
}
