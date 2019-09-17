package com.wander.manifold.service.impl;

import com.wander.manifold.mapper.BackMapper;
import com.wander.manifold.pojo.User;
import com.wander.manifold.service.IBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("backService")
public class BackService implements IBackService {

    @Autowired
    private BackMapper backMapper;


  /*  @Override
    public List<User> queryAll() {
        return backMapper.queryAll();
    }*/

    @Override
    public List<User> query(Integer page, Integer pageSize) {
        Integer start = (page - 1) * pageSize;
        Integer size = pageSize;
        return backMapper.query(start, size);
    }

    @Override
    public List<User> queryblock(Integer start, Integer size) {
        return backMapper.queryblock(start,size);
    }

    @Override
    public Integer count() {
        return backMapper.count();
    }

    @Override
    public Integer add(User user) {
        return backMapper.add(user);
    }

    @Override
    public Integer update(Long uid) {
        Integer i=backMapper.update(uid);
        return i;
    }

    @Override
    public Integer update2(Long uid) {
        Integer i=backMapper.update2(uid);
        return i;
    }



}
