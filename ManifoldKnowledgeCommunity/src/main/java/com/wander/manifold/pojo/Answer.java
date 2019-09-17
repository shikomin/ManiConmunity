package com.wander.manifold.pojo;

import java.io.Serializable;

/**
 * Created by 胥珂铭 on 2019/8/4.
 */
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long answerId;
    private Question question;
    private String content;
    private User user;
    private Long agree;
    private Long disagree;
    private Long readTimes;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getAgree() {
        return agree;
    }

    public void setAgree(Long agree) {
        this.agree = agree;
    }

    public Long getDisagree() {
        return disagree;
    }

    public void setDisagree(Long disagree) {
        this.disagree = disagree;
    }

    public Long getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(Long readTimes) {
        this.readTimes = readTimes;
    }
}
