package music.mapper;

import music.config.MapperConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MapperConfig.class)
public class MusicMapperTest {
    @Resource
    private MusicMapper musicMapper;
    @Test
    public void selectAll() {
        System.out.println(musicMapper.selectAll());
    }
}