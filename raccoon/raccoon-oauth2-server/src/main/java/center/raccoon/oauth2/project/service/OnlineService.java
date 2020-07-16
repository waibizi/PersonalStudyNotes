package center.raccoon.oauth2.project.service;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 歪鼻子
 * @Date 2020/7/10 21:41
 * @Description:
 * @Version 1.0
 */
public interface OnlineService {
    void insertOnlineUser(String userName, OAuth2AccessToken body, HttpServletRequest request);
    void kickOut(String userName);
}
