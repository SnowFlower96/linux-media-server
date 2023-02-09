package com.my.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private final int ONE_SECONDS = 1000;
    private final int ONE_MINUTE = 60 * ONE_SECONDS;
    private final String KEY_ROLES = "roles";

    private final byte[] secretKeyBytes;
    private final byte[] refreshSecretKeyBytes;
    private final int expireMin;
    private final int refreshExpireMin;

    public JwtTokenUtil(
            @Value("${jwt.secret}") String secretKey,
            @Value("${jwt.refresh-secret}") String refreshSecretKey,
            @Value("${jwt.expire-min:10}") int expireMin,
            @Value("${jwt.refresh-expire-min:30}") int refreshExpireMin) {
        this.secretKeyBytes = secretKey.getBytes();
        this.refreshSecretKeyBytes = refreshSecretKey.getBytes();
        this.expireMin = expireMin;
        this.refreshExpireMin = refreshExpireMin;
    }

}
