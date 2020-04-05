package music.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private String salt;
    private String email;
    private String phoneNumber;
    private Integer status;
    private Integer binding;
    private Integer credits;
    private Date createTime;
    private Date lastLoginTime;
    private List<Music> musics;
}
