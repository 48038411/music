package music.service.impl;


import music.entity.User;
import music.mapper.UserMapper;
import music.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-02 10:20
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 登录
     * @param user
     */
    @Override
    public void userSign(User user) {
        userMapper.userSign(user);
    }

    /**
     * 注册
     * @param name
     * @return
     */
    @Override
    public User userLogin(String name) {
        return userMapper.userLogin(name);
    }

    /**
     * 获得积分
     * @param user
     */
    @Override
    public void updateCredits(User user) {
        userMapper.updateCredits(user);
    }
}
