package com.sznt.shop.auth.config;

import cn.hutool.crypto.digest.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * Security 核心配置类
 *
 * @author S Mr.L 
 * @since 2021-06-12
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * 注入 Redis 连接工厂
     */
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * 初始化RedisTokenStore, 用于将 Token 存储至 Redis
     * @return {@link RedisTokenStore}
     */
    @Bean
    public RedisTokenStore redisTokenStore() {
        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
        // 设置 Redis Key 的层级, 方便查询
        redisTokenStore.setPrefix("TOKEN:");
        return redisTokenStore;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {

            /**
             * 密码加密
             * @param rawPassword 原始密码
             * @return 加密后的密码
             */
            @Override
            public String encode(CharSequence rawPassword) {
                return DigestUtil.md5Hex(rawPassword.toString());
            }

            /**
             * 密码是否匹配
             * @param rawPassword 原始密码
             * @param encodedPassword 加密后的密码
             * @return 密码校验结果
             */
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return DigestUtil.md5Hex(rawPassword.toString()).equals(encodedPassword);
            }
        };
    }

    /**
     * 初始化认证管理对象, 一定要加上{@code Bean}, 不然启动的时候会报错
     * @return {@link AuthenticationManager}
     * @throws Exception {{@link WebSecurityConfigurerAdapter#authenticationManagerBean()}}
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 放行和认证规则
     * @param http {@link HttpSecurity}
     * @throws Exception {{@link HttpSecurity#authorizeRequests()}}
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                // 放行的请求
                .antMatchers("/oauth/**", "/actuator/**").permitAll()
                .and()
                .authorizeRequests()
                // 其他请求必须认证才能访问
                .anyRequest().authenticated();
    }

}
