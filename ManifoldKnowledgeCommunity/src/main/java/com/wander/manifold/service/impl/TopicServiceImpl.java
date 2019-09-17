package com.wander.manifold.service.impl;

import com.wander.manifold.mapper.ITopicMapper;
import com.wander.manifold.pojo.Topic;
import com.wander.manifold.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/7/31.
 */

@Service("topicService")
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private ITopicMapper topicMapper;

    @Override
    public Topic queryRoot() {
        return topicMapper.queryRoot();
    }

    @Override
    public Topic queryAncestor(Long topicId) {
        return topicMapper.queryAncestor(topicId);
    }

    @Override
    public List<Topic> querySonTopic(Long topicId) {
        return topicMapper.querySonTopic(topicId);
    }

    @Override
    public Integer addTopic(Topic topic) {
        return topicMapper.insert(topic);
    }

    @Override
    public List<Topic> queryTopicByKeyword(String keyword) {
        return topicMapper.queryTopicByKeyword("%"+keyword+"%");
    }

    @Override
    public List<Long> queryTopicIdByQuestionId(Long questionId) {
        return topicMapper.queryTopicIdByQuestionId(questionId);
    }
}
