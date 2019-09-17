package com.wander.manifold.service;

import com.wander.manifold.pojo.User;

public interface IUserService {

    User queryByEmailPsw(String email, String password);

    Integer activation(String email);

    Integer addUser(User user);

    User queryById(Long uid);

    Integer update(Long uid,String username,Integer gender,String avatar,String phone,String industry,String education);

    Integer followAction(Long followed,Long follower);

}
