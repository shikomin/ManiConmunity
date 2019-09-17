package com.wander.manifold.pojo;

import java.io.Serializable;

/**
 * Created by 胥珂铭 on 2019/8/6.
 */
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long commentId;
    private Long answerId;
    private User user;
    private User replyToUser;
    private String content;
    private Integer agree;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getReplyToUser() {
        return replyToUser;
    }

    public void setReplyToUser(User replyToUser) {
        this.replyToUser = replyToUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }
}
