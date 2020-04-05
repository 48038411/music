package music.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName Music
 * @Description TODO
 * @Author wangqingyuan
 * @Date 2020/4/2 &10:50
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Music {
    private int id;
    private String name;
    private String author;
    private String src;
    private String img;
    private int count;
    private String type;
    private String update_time;
    private List<User> users;
}
