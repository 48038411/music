package music.service.impl;

import music.entity.UserMusic;
import music.mapper.UserMusicMapper;
import music.service.UserMusicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jh_wu
 * @ClassName UserMusicServiceImpl
 * @Description TODO
 * @Date 2020/4/3:12:09
 * @Version 1.0
 **/
@Service
public class UserMusicServiceImpl implements UserMusicService {
    @Resource
    private UserMusicMapper userMusicMapper;
    @Override
    public void likeMusic(UserMusic userMusic) {
        userMusicMapper.likeMusic(userMusic);
    }

    @Override
    public int batchDelete(List<Integer> idList) {
        return userMusicMapper.batchDelete(idList);
    }

    @Override
    public int batchInsert(List<UserMusic> userMusics) {
        return userMusicMapper.batchInsert(userMusics);
    }

    @Override
    public UserMusic re(Integer userId, Integer musicId) {
        return userMusicMapper.re(userId,musicId);
    }
}
