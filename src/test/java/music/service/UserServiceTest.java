package music.service;

import music.config.MapperConfig;
import music.entity.User;
import music.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MapperConfig.class)
public class UserServiceTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void userSign() {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        String pwd = BCrypt.hashpw("1234",BCrypt.gensalt());
        User user = User.builder()
                .name("郭花花")
                .password(pwd)
                .salt(BCrypt.gensalt())
                .email("111@qq.com")
                .phoneNumber("114")
                .status(1)
                .binding(1)
                .credits(0)
                .createTime(date)
                .lastLoginTime(date)
                .build();
//        盐值修改后的密码
        System.out.println(user.getPassword());
//        盐值
        System.out.println(BCrypt.gensalt());
        userMapper.userSign(user);
    }



    @Test
    public void updateCredits() {
        String inputPassword = "1234";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //验证密码
        if (!encoder.matches(inputPassword,userMapper.userLogin("郭花花").getPassword())){
            User user = userMapper.userLogin("郭花花");

            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
            Date date = new Date();// 获取当前时间

            //计算当前时间和登录的时间差(天数差),并改变最后登录时间
            long nowTime = date.getTime();
            long lastLoginTime = user.getLastLoginTime().getTime();
            int days = (int) ((nowTime - lastLoginTime) / (1000 * 60 * 60 * 24));
            System.out.println(days);

            //更新
            if (days >=1){
                //将之前积分与现在获得积分累加
                int creditsCounts = user.getCredits() + 5;
                user.setCredits(creditsCounts);
                user.setLastLoginTime(date);
                userMapper.updateCredits(user);
            }
        }
    }


    @Test
    public void userLogin() {
        String finallPassword = "22";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(finallPassword,userMapper.userLogin("花花1").getPassword())){
            System.out.println("登录失败");
        }else {
            System.out.println("登录成功");
        }
    }
}