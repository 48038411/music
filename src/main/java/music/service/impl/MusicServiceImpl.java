package music.service.impl;


import music.entity.Music;
import music.mapper.MusicMapper;
import music.service.MusicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName MusicServiceImpl
 * @Description TODO
 * @Author wangqingyuan
 * @Date 2020/4/2 &11:58
 * @Version 1.0
 **/
@Service
public class MusicServiceImpl implements MusicService {
    @Resource
    private MusicMapper musicMapper;
    @Override
    public int bathInsert(List<Music> musics) {
        return musicMapper.batchInsert(musics);
    }

    @Override
    public List<Music> selectAll() {
        return musicMapper.selectAll();
    }
}
