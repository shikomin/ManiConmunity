package com.wander.manifold.mapper;

import com.wander.manifold.pojo.User;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface IUserMapper {

    User queryByEmailPsw(String email, String password);

    Integer activation(String email);

    Integer insert(User user);

    User queryById(Long uid);

    Integer update(Long uid,String username, Integer gender, String avatar, String phone, String industry, String education);

    Integer followAction(Long followed,Long follower);

}
