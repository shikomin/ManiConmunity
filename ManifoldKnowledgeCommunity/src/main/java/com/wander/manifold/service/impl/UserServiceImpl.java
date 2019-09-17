package com.wander.manifold.service.impl;

import com.wander.manifold.mapper.IUserMapper;
import com.wander.manifold.pojo.User;
import com.wander.manifold.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User queryByEmailPsw(String email, String password) {
        return userMapper.queryByEmailPsw(email, password);
    }

    @Override
    public Integer activation(String email) {
        return userMapper.activation(email);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User queryById(Long uid) {
        return userMapper.queryById(uid);
    }

    @Override
    public Integer update(Long uid,String username, Integer gender, String avatar, String phone, String industry, String education) {
        return userMapper.update(uid,username,gender,avatar,phone,industry,education);
    }

    @Override
    public Integer followAction(Long followed, Long follower) {
        return userMapper.followAction(followed,follower);
    }
}
