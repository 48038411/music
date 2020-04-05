package music.mapper;


import music.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    /**
     * 用户登录
     *
     * @param name
     * @return User
     */
    @Select("SELECT * FROM t_user WHERE name = #{name}  ")
    User userLogin(String name);

    /**
     * 注册一个用户
     *
     * @param user
     */
    @Insert(" INSERT INTO t_user (name, password, salt, email, phone_number, status, binding, credits, create_time, last_login_time)\n" +
            "        VALUES (#{name},#{password},#{salt},#{email},#{phoneNumber},#{status},#{binding},#{credits},#{createTime},#{lastLoginTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void userSign(User user);

    /**
     *更新积分和登录时间
     *
     * @param user
     */
    @Update("UPDATE t_sys_user SET credits = #{credits} , last_login_time = #{lastLoginTime} WHERE id = ${id}")
    void updateCredits(User user);

}
