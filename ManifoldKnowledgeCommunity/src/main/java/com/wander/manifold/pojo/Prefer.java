package com.wander.manifold.pojo;

import java.io.Serializable;

/**
 * Created by 胥珂铭 on 2019/8/7.
 */
public class Prefer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long uid;
    private Long topicId;
    private Long value;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
