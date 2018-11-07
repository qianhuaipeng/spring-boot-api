package com.alan.api.core.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * author: alan.peng
 * description: json web token 配置
 * date: create in 14:04 2018/11/7
 * modified By：
 */
@Component
@ConfigurationProperties(prefix = "jwt")
@Data
public class JWTSetting {

    private String authoritiesKey;

    /**
     * RSA 私钥
     */
    private String privateKey;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * token 前缀
     */
    private String tokenPrefix;

    /**
     * 存放token的header key
     */
    private String header;

    /**
     * 有效期
     */
    private long expirationTime;
}
