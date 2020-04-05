package music.mapper;

import music.entity.Music;
import org.apache.ibatis.annotations.Insert;
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
    @Insert("<script>" +
            "INSERT INTO music VALUES" +
            "<foreach collection=\"musics\" item=\"item\" index=\"index\" separator=\",\">" +
            "(#{item.id},#{item.name},#{item.author},#{item.src},#{item.img},#{item.count},#{item.type},#{item.update_time})" +
            "</foreach>" +
            "</script>")
    int batchInsert(@Param("musics") List<Music> musics);
}
