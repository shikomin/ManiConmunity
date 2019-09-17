package com.wander.manifold.controller;

import com.sun.corba.se.spi.ior.ObjectKey;
import com.wander.core.utils.JwtTokenUtil;
import com.wander.manifold.pojo.User;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 胥珂铭 on 2019/8/2.
 */
@RestController
@RequestMapping("/manifold")
public class CheckTokenController {

    private static final Logger log = LoggerFactory.getLogger(CheckTokenController.class);

    /**
     * 用于验证身份的控制器
     * for identity verification
     */
    @Value("${auth.header}")
    private String authHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 检验Token
     *
     * @param req
     * @return
     */
    @GetMapping("/chkToken")
    public ResponseEntity<?> chk(HttpServletRequest req) {
        // 通过请求头获得token
        String token = req.getHeader(authHeader);
        User user = new User();
        if (token != null) {
            // 进行token检验
            try {
                Claims c = jwtTokenUtil.parseJWT(token);
                Map<String, Object> userMap = (LinkedHashMap) (c.get("User"));

                user.setUid(Long.parseLong((userMap.get("uid")).toString()));
                user.setEmail((String) userMap.get("email"));
                user.setPassword((String) userMap.get("password"));
                user.setUsername((String) userMap.get("username"));
                user.setStatus((Integer) userMap.get("status"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                user.setJoinTime(sdf.parse(userMap.get("joinTime").toString()));
                user.setGender((Integer) userMap.get("gender"));
                user.setPhone((String) userMap.get("phone"));
                user.setAvatar((String) userMap.get("avatar"));
                user.setIntro((String) userMap.get("intro"));
                user.setIndustry((String) userMap.get("industry"));
                user.setEducation((String) userMap.get("education"));
                user.setLikedCount((Integer) userMap.get("likedCount"));
                user.setFollowCount((Integer) userMap.get("followCount"));
                user.setFollowerCount((Integer) userMap.get("followerCount"));
                user.setScanCount((Integer) userMap.get("scanCount"));
                user.setScanCount((Integer) userMap.get("score"));
                log.info("用户{}通过验证", user.getEmail());
                return new ResponseEntity<User>(user, HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                user.setEmail("fail");
                return new ResponseEntity<User>(user, HttpStatus.OK);
            }
        }
        user.setEmail("fail");
        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

}
