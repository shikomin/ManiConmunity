package com.wander.manifold.mapper;

import com.wander.manifold.pojo.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/7/31.
 */

@Repository("topicMapper")
public interface ITopicMapper {

    //查找根话题
    Topic queryRoot();

    //查找祖先话题
    Topic queryAncestor(Long topicId);

    //查找子孙话题
    List<Topic> querySonTopic(Long topicId);

    //新增话题
    Integer insert(Topic topic);

    //关键词查找话题
    List<Topic> queryTopicByKeyword(String keyword);

    List<Long> queryTopicIdByQuestionId(Long questionId);

}
