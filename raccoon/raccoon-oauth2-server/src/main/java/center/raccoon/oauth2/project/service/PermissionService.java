package center.raccoon.oauth2.project.service;

import center.raccoon.oauth2.project.model.Permission;

import java.util.List;

/**
 * @Author xiaoxiong
 * @Date2020/5/27 20:21
 * @Description:权限服务接口
 * @Version 1.0
 */
public interface PermissionService {
    /**
     * 根据用户ID获取权限
     * @param userId
     * @return
     */
    List<Permission> getPermissionByUserId(Integer userId);
}
