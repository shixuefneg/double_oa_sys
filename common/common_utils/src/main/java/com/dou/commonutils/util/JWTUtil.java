package com.dou.commonutils.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Description JWT工具类 （自包含令牌是通过一定规则生成的字符串，包含用户信息，而JWT就是一种官方推荐的生成规则）
 * JWT包含三部分：
 * 1、jwt头信息
 * 2、有效载荷 包含主体信息（用户信息）
 * 3、签名哈希（防伪标志）
 * @Date 2022/2/21 下午4:38
 */
public class JWTUtil {

    public static final long EXPIRE = 1000 * 60 * 60 * 24;  //token过期时间
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";   //密钥，为了之后的加密或编码

    //生成token字符串的方法
    public static String getJwtToken(String id, String nickname){
        String JwtToken = Jwts.builder()
                //头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("ly-user")    //分类
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))   //过期时间
                //设置token主体部分，存储用户信息
                .claim("id", id)
                .claim("nickname", nickname)    //nickname，自定义的变量，代表用户昵称
                .signWith(SignatureAlgorithm.HS256, APP_SECRET) //签名哈希
                .compact();
        return JwtToken;
    }

        /**
         * 判断token是否存在与有效
         * @param jwtToken
         * @return
         */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

        /**
         * 判断token是否存在与有效
         * @param request
         * @return
         */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if(StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

        /**
         * 根据token获取会员id，即从token字符串中获取想要的用户信息
         * @param request
         * @return
         */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");   //从请求头header中获取token
        if(StringUtils.isEmpty(jwtToken)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();    //获取主体部分
        return (String)claims.get("id");    //获取主体部分中想要的用户信息
    }
}
