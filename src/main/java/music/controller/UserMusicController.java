package music.controller;

import com.alibaba.fastjson.JSON;
import music.entity.UserMusic;
import music.service.UserMusicService;
import music.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jh_wu
 * @ClassName UserMusicController
 * @Description TODO
 * @Date 2020/4/5:13:36
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/api/userMusic")
public class UserMusicController {
    @Resource
    private UserMusicService userMusicService;
    @ResponseBody
    @RequestMapping("/like")
    public String register(@RequestParam(value = "user_id") Integer userId, @RequestParam(value = "music_id") Integer musicId) {
        if (userMusicService.re(userId,musicId)==null) {
            UserMusic userMusic = UserMusic.builder()
//                        .id(null)
                    .musicId(musicId)
                    .userId(userId)
                    .build();
            userMusicService.likeMusic(userMusic);
            System.out.println(userMusic);
            Result ro = new Result(1, "成功");
            return JSON.toJSONString(ro);
        }
        else {
            Result ro = new Result(1, "失败");
            return JSON.toJSONString(ro);
        }
    }
    @RequestMapping(value = "cancel",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public String cancelUser(@RequestParam(value = "id")Integer id){
            List<Integer> idList = new ArrayList<>();
            idList.add(id);
            userMusicService.batchDelete(idList);
            Result ro = new Result(1, "成功");
            return JSON.toJSONString(ro);
    }
}
