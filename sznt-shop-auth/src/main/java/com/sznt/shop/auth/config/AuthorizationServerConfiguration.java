package com.sznt.shop.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 授权服务配置
 *
 * @author S Mr.L 
 * @since 2021-06-12
 */
@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    /**
     * reids 令牌存储对象
     * {@link WebSecurityConfiguration#redisTokenStore()}
     */
    private final RedisTokenStore redisTokenStore;

    /**
     * 认证管理对象
     */
    private final AuthenticationManager authenticationManager;

    /**
     * 密码编码器
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * 配置令牌断点安全约束
     * @param security 安全配置器
     * @throws Exception {{@link #configure(AuthorizationServerSecurityConfigurer)}}
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许访问 Token 的公钥, 默认/oauth/token_key是受保护的
        security.tokenKeyAccess("permitAll()")
                // 允许检查 Token 的状态, 默认/oauth/check_token是受保护的
                .checkTokenAccess("permitAll()");
    }

    /**
     * 客户端授权模型配置
     * @param clients 客户端配置对象
     * @throws Exception {{@link #configure(ClientDetailsServiceConfigurer)}}
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        super.configure(clients);
    }

    /**
     * 配置授权以及令牌的访问端点和令牌服务
     * @param endpoints 访问端点配置器
     * @throws Exception {{@link #configure(AuthorizationServerEndpointsConfigurer)}}
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
    }

}
