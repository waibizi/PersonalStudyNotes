package center.raccoon.oauth2.project.mapper;

import center.raccoon.oauth2.project.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author xioaxiong
 * @Date2020/5/27 20:21
 * @Description:定义user的Mapper
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名获取用户的详情
     * @param username
     * @return
     */
    User getUserByUserName(@Param("username") String username);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);
}
