package music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author 田震
 * @Date 2020/3/24
 **/
@Controller
@RequestMapping("/users")
public class HelloController {

    @GetMapping("/homes")
    public String homes(Model model){
        model.addAttribute("message","Hello Spring MVC");
        model.addAttribute("","");
        System.out.println("121");
        return "homes";
    }

}