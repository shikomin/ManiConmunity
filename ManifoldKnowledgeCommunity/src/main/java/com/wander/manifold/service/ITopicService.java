package com.wander.manifold.service;

import com.wander.manifold.pojo.Topic;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/7/31.
 */
public interface ITopicService {

    //查找根话题
    Topic queryRoot();
    //查找祖先话题
    Topic queryAncestor(Long topicId);

    //查找子孙话题
    List<Topic> querySonTopic(Long topicId);

    //新增话题
    Integer addTopic(Topic topic);

    //关键词查找话题
    List<Topic> queryTopicByKeyword(String keyword);

    List<Long> queryTopicIdByQuestionId(Long questionId);
}
