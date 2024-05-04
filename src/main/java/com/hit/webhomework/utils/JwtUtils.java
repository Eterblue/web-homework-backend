package com.hit.webhomework.utils;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

public class JwtUtils {

    //设置过期时间1h
    private static final Long EXPIRE = 24 * 60 * 60 * 1000L;
    //设置私钥
    private static final String SECRET_KEY = "T738eZvNyLkp3TYErvSH3UMSrLC5xL7J";
    //密钥
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public static String getToken(String id) {
        return Jwts.builder()
                .header()//头信息
                .add("typ", "JWT")
                .add("alg", "HS256")
                .and()
                .claim("id", id)
                .id(String.valueOf(IdUtil.simpleUUID()))//标识id
                .expiration(Date.from(Instant.now().plusSeconds(EXPIRE)))//过期时间
                .issuedAt(new Date())//签发时间
                .issuer("xy")//签发者
                .signWith(KEY, Jwts.SIG.HS256)//签名
                .compact();
    }

    public static Boolean verify(String token) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
        } catch (IllegalArgumentException | JWTVerificationException e){
            return false;
        }
        return true;
    }

    public static Jws<Claims> parseClaim(String token) {
        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token);
    }

//    public static Object parseSubject(String token) {
//        return parsePayload(token).get("sub");
//    }

    public static JwsHeader parseHeader(String token) {
        return parseClaim(token).getHeader();
    }

    public static Claims parsePayload(String token) {
        return parseClaim(token).getPayload();
    }

}