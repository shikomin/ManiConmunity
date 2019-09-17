package com.wander.manifold.service;

import com.wander.manifold.pojo.Comment;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/6.
 */
public interface ICommentService {

    Integer add(Comment comment);

    List<Comment> queryByAnswerId(Long answerId);

}
