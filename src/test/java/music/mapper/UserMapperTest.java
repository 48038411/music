package music.mapper;

import music.config.MapperConfig;
import music.entity.Music;
import music.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MapperConfig.class)
public class UserMapperTest {
@Resource
UserMapper userMapper;
    @Test
    public void getMusicById() {
        List<Music> musics = userMapper.getMusicById(815650);
        musics.forEach(music -> {
            System.out.println(
                    music.getId()
                            +","+music.getName()
                            +","+music.getAuthor()
                            +","+music.getImg()
            );
        });
    }
}