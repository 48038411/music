package music.controller;

import music.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-04 16:23
 */
@Controller
@RequestMapping(value = "/api/music")
public class MusicController {
    @Resource
    private MusicService musicService;
    @ResponseBody
    @GetMapping("/all")
    public String musicAll(Model model){
        model.addAttribute("allMusic","musicService.selectAll()");
        System.out.println("124");
        return "music";
    }
}
