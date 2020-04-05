package music.service;


import music.entity.Music;

import java.util.List;

/**
 * @ClassName MusicService
 * @Description TODO
 * @Author wangqingyuan
 * @Date 2020/4/2 &11:57
 * @Version 1.0
 **/
public interface MusicService {
    /**
     * 批量插入
     * @param musics
     * @return int[]
     */
    int bathInsert(List<Music> musics);

    /**
     * 查询所有音乐
     * @return
     */
    List<Music> selectAll();
}
