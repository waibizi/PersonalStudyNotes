package center.raccoon.oauth2.framework.config;

import center.raccoon.oauth2.project.model.RaccoonUserDetails;
import center.raccoon.oauth2.project.model.Permission;
import center.raccoon.oauth2.project.model.User;
import center.raccoon.oauth2.project.service.PermissionService;
import center.raccoon.oauth2.project.service.UserService;
import com.alibaba.druid.util.StringUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 歪鼻子
 * @Date 2020/7/7 0:01
 * @Description: 自定义用户详情处理器
 * @Version 1.0
 */
@Service
public class RaccoonUserDetailsService implements UserDetailsService {
    /**
     * 注入UserService
     */
    @Autowired
    UserService userService;
    /**
     *注入permissionService
     */
    @Autowired
    PermissionService permissionService;
    /**
     *重写loadUserByUsername方法:根据用户名加载用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         * 创建用户详情对象
         */
        RaccoonUserDetails raccoonUserDetails = new RaccoonUserDetails();
        /**
         * 根据用户名查询用户信息
         */
        User user = userService.getUserByUserName(username);
        /**
         * 设置用户详情对象属性
         */
        raccoonUserDetails.setUsername(user.getUserName());
        raccoonUserDetails.setPassword(user.getUserPassword());
        /**
         * 设置该用户是否可用
         */
        String enable="1";
        if(StringUtils.equals(user.getUserEnable(),enable)){
            raccoonUserDetails.setEnabled(true);
        }else{
            raccoonUserDetails.setEnabled(false);
        }
        /**
         * 获取权限信息
         */
        List<GrantedAuthority> grantedAuthorities= Lists.newArrayList();
        if(user!=null){
            List<Permission> permissions=permissionService.getPermissionByUserId(user.getUserId());
            permissions.forEach(permission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermissionType());
                grantedAuthorities.add(grantedAuthority);
            });
            raccoonUserDetails.setAuthorities(grantedAuthorities);
        }
        return raccoonUserDetails;
    }

}
