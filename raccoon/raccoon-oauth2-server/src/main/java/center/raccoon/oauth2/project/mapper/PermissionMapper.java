package center.raccoon.oauth2.project.mapper;

import center.raccoon.oauth2.project.model.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author xioaxiong
 * @Date2020/5/27 20:21
 * @Description:定义permission的Mapper
 * @Version 1.0
 */
@Mapper
public interface PermissionMapper {
    /**
     * 根据用户的ID获取所有权限
     * @param userId
     * @return
     */
    List<Permission> getPermissionByUserId(Integer userId);
}
