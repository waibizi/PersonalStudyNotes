package center.raccoon.oauth2.project.service.impl;
/**
 * @Author xiaoxiong
 * @Date2020/5/27 20:21
 * @Description:权限逻辑处理类
 * @Version 1.0
 */
import center.raccoon.oauth2.project.mapper.PermissionMapper;
import center.raccoon.oauth2.project.model.Permission;
import center.raccoon.oauth2.project.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    /**
     * 自动注入PermissionMapper
     */
    @Autowired
    PermissionMapper permissionMapper;

    /**
     * 根据用户ID获取权限
     * @param userId
     * @return
     */
    @Override
    public List<Permission> getPermissionByUserId(Integer userId) {
        return permissionMapper.getPermissionByUserId(userId);
    }
}
