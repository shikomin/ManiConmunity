package com.wander.manifold.controller;

import com.wander.core.utils.EncryptionUtil;
import com.wander.manifold.pojo.User;
import com.wander.manifold.service.IUserService;
import com.wander.core.utils.KemingCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 胥珂铭 on 2019/7/29.
 */
@Controller
public class UserActivationController {

    //Redis操作Template
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //keming加密-密钥
    @Value("${keming.secretKey}")
    private String kmSecretKey;

    //用户服务层
    @Autowired
    private IUserService userService;

    @GetMapping("/activation")
    public String activation(String code) {
        //解密字符串
        //String str = KemingCodeUtil.decode(code, kmSecretKey);//keming解密
        String str= EncryptionUtil.convertMD5(EncryptionUtil.convertMD5(code));//MD5解密

        //解析字符串
        String[] strArr = str.split("#div#");
        String email = strArr[0];
        String userCode = strArr[1];

        ValueOperations<String, Object> value = redisTemplate.opsForValue();
        String realCode = (String) value.get(email);

        if (userCode.equals(realCode)) {
            //验证通过，从Redis中拿出user
            User user = (User) value.get(email + "_info");
            user.setStatus(1);
            //写入mysql数据库
            userService.addUser(user);
            return "manifold.html";
        }
        return "login.html";
    }

}
