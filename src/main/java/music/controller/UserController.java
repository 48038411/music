package music.controller;

import music.entity.User;
import music.mapper.UserMapper;
import music.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-04 11:33
 */
//返回json视图的注释
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    private UserService userService;


    //
    @GetMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView();
        String username = user.getName();
        String password = user.getPassword();
        //解盐
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (userService.userLogin(username) !=null){
            //用户存在
            if (!encoder.matches(password, userService.userLogin(username).getPassword())){
               modelAndView.setViewName("密码错误，请您重新输入");
            }else {
                modelAndView.setViewName("登录成功");
            }
        }else{
            modelAndView.setViewName("用户不存在，请您注册后，在进行登录");
        }
        //这里用service层从数据库中先查询该用户是否存在，再查询密码是否正确
        //如果都符合，return "登录成功"
        //如果用户名不存在，return "用户名不存在"
        return "测试";
    }

}
