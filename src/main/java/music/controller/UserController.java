package music.controller;

import music.entity.User;
import music.mapper.UserMapper;
import music.service.UserService;
import music.util.PhoneCode;
import music.util.SendMessage;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @GetMapping(value = "/sendSms")
    public void defaultKaptcha(@RequestParam String mobile, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("杨苏祥");
        //获取验证码,并且保存在session中
        PhoneCode phoneCode = new PhoneCode();
        String code = phoneCode.getCode();
        HttpSession hs = httpServletRequest.getSession();
        hs.setAttribute("code", code);
        System.out.println(code);
        System.out.println(mobile);
        //发送验证码
        SendMessage.sendSms(mobile, code);
    }

    //注册短信验证
    @GetMapping("/checkLogin")
    public ModelAndView checkLogin(@RequestParam String frontCode, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println("严肃性");
        ModelAndView modelAndView = new ModelAndView();
        //前端输入框输入的验证码
        String userCode = frontCode;
        //发送的验证码
        String endCode = (String) httpServletRequest.getSession().getAttribute("code");
        //判断验证码是否正确
        if (!userCode.equals(endCode)) {
            modelAndView.addObject("info","错误的验证码");
            modelAndView.setViewName("failed");
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
            Date date = new Date();// 获取当前时间

            String pwd = BCrypt.hashpw("22",BCrypt.gensalt());
            User user = User.builder()
                    .name("花花")
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
            userService.userSign(user);
            modelAndView.addObject("info","注册成功");
            modelAndView.setViewName("success");
        }
        return modelAndView;
    }

}
