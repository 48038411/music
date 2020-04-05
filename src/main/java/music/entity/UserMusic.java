package music.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jh_wu
 * @ClassName UserMusic
 * @Description TODO
 * @Date 2020/4/3:11:56
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserMusic {
    private Integer id;
    private Integer musicId;
    private Integer userId;
}
