package center.raccoon.oauth2.project.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author xiaoxiong
 * @Date2020/5/27 20:21
 * @Description:自定义用户详情实体类
 * @Version 1.0
 */
public class RaccoonUserDetails implements UserDetails {
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户名
     */
    private String username;
    /**
     * 账户是否过期
     */
    private Boolean accountNonExpired;
    /**
     * 账户是否锁定
     */
    private Boolean accountNonLocked;
    /**
     * 认证是否过期
     */
    private Boolean credentialsNonExpired;
    /**
     * 用户是否可用
     */
    private Boolean enabled;
    /**
     * 用户权限
     */
    Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
