package music.mapper;

import music.entity.UserMusic;
import org.apache.ibatis.annotations.Param;

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
    void likeMusic(UserMusic userMusic);
    /**
     * 批量删除
     * @param idList
     * @return
     */
    int batchDelete(@Param("idList") List<Integer> idList);
    /**
     * 批量插入
     * @param userMusics
     * @return int
     */
    int batchInsert(@Param("userMusics") List<UserMusic> userMusics);
}
