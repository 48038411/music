package music.mapper;

import music.config.MapperConfig;
import music.entity.UserMusic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MapperConfig.class)
public class UserMusicMapperTest {
    @Resource
    private UserMusicMapper userMusicMapper;
    @Test
    public void likeMusic() {
        UserMusic userMusic = UserMusic.builder()

                .musicId(6)
                .userId(2)
                .build();
        userMusicMapper.likeMusic(userMusic);
    }

    @Test
    public void batchDelete() {
        List<Integer> idList = new ArrayList<>();
        for (int i=0;i<10;i++){
            idList.add(1+i);
        }
        System.out.println(userMusicMapper.batchDelete(idList));
    }
    @Test
    public void batchInsert() {
        List<UserMusic> userMusics = new ArrayList<>();
        for (int i = 0;i<10;i++){
            UserMusic userMusic = UserMusic.builder()
                    .id(1+i)
                    .musicId(1)
                    .userId(1)
                    .build();
            userMusics.add(userMusic);
        }
        System.out.println(userMusicMapper.batchInsert(userMusics));
    }

    @Test
    public void re() {
        UserMusic userMusic = UserMusic.builder()
                .musicId(1)
                .userId(1)
                .build();
        System.out.println(userMusicMapper.re(1,1));
    }
}