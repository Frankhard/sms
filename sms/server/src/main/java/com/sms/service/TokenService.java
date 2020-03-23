package com.sms.service;

import com.sms.utils.RedisUtil;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service("tokenService")
public class TokenService {
    @Resource
    private RedisUtil redisUtil;

    //生成token(格式为token:设备-加密的用户名-时间-六位随机数)
    public String generateToken(String userAgentStr, String no) {
        /*StringBuilder token = new StringBuilder(no);*/
        StringBuilder token = new StringBuilder("token:");
        //设备
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
        if (userAgent.getOperatingSystem().isMobileDevice()) {
            token.append("MOBILE-");
        } else {
            token.append("PC-");
        }
        //加密的用户名
        token.append(DigestUtils.md5Hex(no) + "-");
        //时间
        token.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "-");
        //六位随机字符串
        token.append(new Random().nextInt(999999 - 111111 + 1) + 111111 );
        System.out.println("tokenService生成token-->" + token.toString());
        return token.toString();
    }

    //把token存到redis中
    public void save(String token, String no) {
        /*if (token.startsWith("token:PC")) {
            redisUtil.setex(token, no,2*60*60);
        } else {
            redisUtil.set(token, no);
        }*/
        redisUtil.set(token, no);
    }

    public void delete(String token){
        redisUtil.deleteKey(token);
    }
}
