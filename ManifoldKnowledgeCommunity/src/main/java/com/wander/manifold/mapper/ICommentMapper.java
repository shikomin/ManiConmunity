package com.wander.manifold.mapper;

import com.wander.manifold.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/6.
 */
@Repository("commentMapper")
public interface ICommentMapper {

    Integer insert(Comment comment);

    List<Comment> queryByAnswerId(Long answerId);

}
