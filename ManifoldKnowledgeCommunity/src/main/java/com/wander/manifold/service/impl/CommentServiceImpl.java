package com.wander.manifold.service.impl;

import com.wander.manifold.mapper.ICommentMapper;
import com.wander.manifold.pojo.Comment;
import com.wander.manifold.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/6.
 */
@Service("commentService")
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentMapper commentMapper;

    @Override
    public Integer add(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public List<Comment> queryByAnswerId(Long answerId) {
        return commentMapper.queryByAnswerId(answerId);
    }
}
