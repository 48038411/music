package music.mapper;

import music.entity.Music;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Guorc
 */
public interface MusicMapper {
    /**
     * 查询所有音乐
     * @return
     */
    @Select("SELECT * FROM music")
    List<Music> selectAll();
    /**
     * 批量插入
     * @param musics
     * @return int
     */
    int batchInsert(@Param("musics") List<Music> musics);
}
