package center.raccoon.oauth2.project.mapper;

import center.raccoon.oauth2.project.model.Login;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author xioaxiong
 * @Date2020/5/30 22:03
 * @Description:定义login的mapper
 * @Version 1.0
 */
@Mapper
public interface LoginMapper {
    /**
     * 添加登录记录
     * @param login
     * @return
     */
    int addLoginRecord(Login login);
}
