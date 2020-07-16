package center.raccoon.oauth2.framework.config;

import center.raccoon.oauth2.framework.exception.CustomWebResponseExceptionTranslator;
import center.raccoon.oauth2.framework.exception.RaccoonAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author 歪鼻子、xiaoxiong
 * @Date 2020/7/5 0:29
 * @Description: 认证服务器配置
 * @Version 1.0
 */
@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 注入加密解密器，加密方法是BCrypt
     */

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 注入认证管理接口类，使用密码方式验证必须注入
     */

    @Autowired
    AuthenticationManager authenticationManager;

    /**
     * 注入数据源，我们已经在yml文件配置
     */

    @Autowired
    DataSource dataSource;

    /**
     * 自定义的用户处理逻辑类
     */

    @Autowired
    RaccoonUserDetailsService raccoonUserDetailsService;
    @Autowired
    CustomWebResponseExceptionTranslator customWebResponseExceptionTranslator;
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    RaccoonAuthExceptionEntryPoint raccoonAuthExceptionEntryPoint;
    @Autowired
    RedisJwtClaimsSetVerifier redisJwtClaimsSetVerifier;



    /**
     * 配置jwt的accessToken转换器
     * 使用的加密方式是非对称加密
     * 密文从resource中的oauth2.jks文件加载
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //这里使用堆成加密，123456789是work key
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("oauth2.jks"), "oauth2".toCharArray()).getKeyPair("oauth2");
        converter.setKeyPair(keyPair);
        converter.setJwtClaimsSetVerifier(redisJwtClaimsSetVerifier);
        return converter;
    }


    /**
     * 定义令牌策略，使用jwt令牌
     * 注入JwtTokenStore使用的令牌策略是JWT
     */


    @Bean()
    public TokenStore JwtTokenStore() {
        return new JwtTokenStore(accessTokenConverter()){
            RedisSerializer<String> stringSerializer = new StringRedisSerializer();
            @Override
            public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
                redisTemplate.setHashKeySerializer(stringSerializer);
                redisTemplate.setHashValueSerializer(stringSerializer);
                if(token.getAdditionalInformation().containsKey("jti")){
                    String jti = token.getAdditionalInformation().get("jti").toString();
                    Map<String, String> map = new HashMap<>(2);
                    map.put("access_token",token.toString());
                    map.put("refresh_token",token.getRefreshToken().toString());
                    redisTemplate.opsForHash().putAll(jti,map);
                    redisTemplate.expire(jti,token.getExpiresIn(),TimeUnit.SECONDS);
                }
                super.storeAccessToken(token, authentication);
            }

            @Override
            public void removeAccessToken(OAuth2AccessToken token) {
                if(token.getAdditionalInformation().containsKey("jti")){
                    String jti = token.getAdditionalInformation().get("jti").toString();
                    redisTemplate.delete(jti);
                }
                super.removeAccessToken(token);
            }

        };
    }


    /**
     *注入ClientDetailsService
     * 表示我们的客户端详情从数据库加载
     * 加密解密方式是BCryptPasswordEncoder
     */

    @Bean
    public ClientDetailsService jdbcClientDetailsService() {
        ClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        ((JdbcClientDetailsService) clientDetailsService).setPasswordEncoder(bCryptPasswordEncoder);
        return clientDetailsService;
    }

    /**
     * 配置令牌的属性以及管理信息
     */

    @Bean
    public AuthorizationServerTokenServices tokenService() {
        DefaultTokenServices service = new DefaultTokenServices();
        /**
         * 支持令牌刷新
         */
        service.setSupportRefreshToken(true);
        /**
         * 令牌管理方式使用jwt模式
         * 则所有信息会被加密成json格式字符串
         * 后端无需保存该token
         */
        service.setTokenStore(JwtTokenStore());
        /**
         * 令牌增强配置
         */
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter()));
        service.setTokenEnhancer(tokenEnhancerChain);
        /**
         * 设置token失效时间
         * access_token失效时间是两个小时
         * refresh_token失效时间是两天
         */
        service.setAccessTokenValiditySeconds(7200);
        service.setRefreshTokenValiditySeconds(259200);
        return service;
    }

    /**
     * 使用jdbc的方式从数据库中加载客户端的信息
     */

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(jdbcClientDetailsService());
    }

    /**
     * 配置端点信息
     */


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        /**
         * 密码授权模式必须要配置authenticationManager
         */

        endpoints.authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
        /**
         * 设置令牌相关信息
         */
        endpoints.tokenServices(tokenService());

       endpoints.exceptionTranslator(customWebResponseExceptionTranslator);

        /**
         * 设置生成token的地址
         */
        endpoints.pathMapping("/oauth/token","/login");
        /**
         * 设置token检查地址
         */
        endpoints.pathMapping("/oauth/check_token","/check");
        /**
         * 设置刷新token地址
         */
        endpoints.pathMapping("/oauth/refresh_token","/refresh");
    }

    /**
     * 授权服务器安全配置
     * @param security
     */

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                /**
                 * oauth/token_key是公开
                 */
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                /**
                 * 表单认证（申请令牌）
                 */
                .allowFormAuthenticationForClients();
                security.authenticationEntryPoint(raccoonAuthExceptionEntryPoint);

    }
}

