package music.service;

import music.entity.Music;
import music.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 注册一个用户
     *
     * @param user
     */
    void userSign(User user);

    /**
     * 用户登录
     *
     * @param name
     * @return User
     */
    User userLogin(String name);

    /**
     * 更新积分和登录时间
     *
     * @param user
     */
    void updateCredits(User user);

    List<Music> getMusicById(int id);
}
