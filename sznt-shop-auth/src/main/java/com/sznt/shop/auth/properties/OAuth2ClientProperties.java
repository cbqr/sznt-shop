package com.sznt.shop.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * OAuth2客户端配置类
 *
 * @author S Mr.L 
 * @since 2021-06-12
 */
@Data
@Component
@ConfigurationProperties(prefix = "oauth2.client")
public class OAuth2ClientProperties {

    /**
     * 客户端标识 ID
     */
    private String clientId;

    /**
     * 客户端安全码
     */
    private String secret;

    /**
     * 授权类型
     */
    private String[] grantTypes;

    /**
     * token有效期
     */
    private int tokenValidityTime;

    /**
     * refresh-token有效期
     */
    private int refreshTokenValidityTime;

    /**
     * 客户端访问范围
     */
    private String[] scopes;

}
