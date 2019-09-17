package com.wander.manifold.controller;

import com.wander.manifold.pojo.Comment;
import com.wander.manifold.pojo.User;
import com.wander.manifold.service.ICommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/6.
 */
@RestController
@RequestMapping("/manifold")
public class CommentController {

    @Resource(name="commentService")
    private ICommentService commentService;

    @PostMapping("/comment/new")
    public ResponseEntity<?> addComment(Long uid,Long answerId,Long replyToUid,String content){
        Comment comment=new Comment();
        User user=new User();
        user.setUid(uid);
        comment.setUser(user);
        comment.setAnswerId(answerId);

        User replyToUser=new User();
        replyToUser.setUid(replyToUid);
        comment.setReplyToUser(replyToUser);
        comment.setContent(content);

        Integer res=commentService.add(comment);

        return new ResponseEntity<Integer>(res, HttpStatus.OK);
    }

    @GetMapping("/comment")
    public ResponseEntity<?> queryByAnswerId(Long answerId){
        List<Comment> comments=commentService.queryByAnswerId(answerId);
        return new ResponseEntity<List<Comment>>(comments,HttpStatus.OK);
    }

}
