package com.bytedance.royal_douyin.util;



import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bytedance.royal_douyin.entity.User;
import com.bytedance.royal_douyin.enums.ErrorEnum;
import com.bytedance.royal_douyin.exception.LocalRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @Author: yumo
 * @Description: JWT工具类
 * @DateTime: 2023/1/22 9:16
 **/
@Component
public class JwtUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);
    private static final String CLAIM_KEY_USERNAME = "user";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;



    /**
     * 根据用户信息生成token
     */
    public String generateToken(User user) {
        return generateToken(user.getName());
    }

    public String generateToken(String username) {
        return JWT.create()
                .withClaim(CLAIM_KEY_USERNAME,username)
                .withClaim(CLAIM_KEY_CREATED,new Date())
                .withExpiresAt(generateExpirationDate())
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * 从token中获取JWT中的负载
     */
    public Map<String, Claim> getClaimsFromToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            Map<String, Claim> claims = decodedJWT.getClaims();
            return claims;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            throw new LocalRuntimeException(ErrorEnum.TOKEN_ERROR);
        }
    }

    /**
     * 生成token的过期时间
     */
    public Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 从token中获取登录用户名
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            username =  getClaimsFromToken(token).get(CLAIM_KEY_USERNAME).asString();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 验证token是否还有效
     *
     * @param token       客户端传入的token
     * @param user 从数据库中查询出来的用户信息
     */
    public boolean validateToken(String token, User user) {
        String username = getUserNameFromToken(token);
        return username.equals(user.getName()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否已经失效
     */
    public boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpiredDateFromToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT.getExpiresAt();
    }



    /**
     * 判断token是否可以被刷新
     */
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     */
    public String refreshToken(String token) {
        String username = getClaimsFromToken(token).get(CLAIM_KEY_USERNAME).asString();
        return generateToken(username);
    }
}

