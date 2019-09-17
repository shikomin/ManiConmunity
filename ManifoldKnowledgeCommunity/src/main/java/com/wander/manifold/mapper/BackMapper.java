package com.wander.manifold.mapper;

import com.wander.manifold.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *持久层
 */
@Repository("backMapper")
public interface BackMapper {
    List<User> query(Integer start, Integer size);

    List<User> queryblock(Integer start, Integer size);

    Integer count();

    Integer add(User user);

     Integer update(Long uid);

    Integer update2(Long uid);

}
