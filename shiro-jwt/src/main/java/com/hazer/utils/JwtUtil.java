package com.hazer.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hazer.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hazer
 */
public class JwtUtil {
    /**  token有效时长*/
    private static final long EXPIRE=90*60*1000L;
    /**  token的密钥*/
    private static final String SECRET="AnyChat";

    private JwtUtil() {
    }

    public static String createToken(User user) {
        //token过期时间
        Date date=new Date(System.currentTimeMillis()+EXPIRE);

        //jwt的header部分
        Map<String ,Object>map=new HashMap<>(64);
        map.put("alg","HS256");
        map.put("typ","JWT");

        //使用jwt的api生成token
        return JWT.create().withHeader(map)
                //私有声明
                .withClaim("username", user.getUsername())
                //过期时间
                .withExpiresAt(date)
                //签发时间
                .withIssuedAt(new Date())
                //签名
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 校验token的有效性，1、token的header和payload是否没改过；2、没有过期
     * @param token token
     * @return boolean
     */
    public static boolean verify(String token){
        try {
            //解密
            JWTVerifier verifier=JWT.require(Algorithm.HMAC256(SECRET)).build();
            verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     *
     * @param token token
     * @return java.lang.String
     */
    public static String getUsername(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


}
