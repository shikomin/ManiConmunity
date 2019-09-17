package com.wander.manifold.service;

import com.wander.manifold.pojo.Question;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/2.
 */
public interface IQuestionService {

    Integer addQuestion(Question question);

    Integer addRelation(Long topicId,Long questionId);

    Question queryByTitle(String title);

    Question queryById(Long questionId);

    List<Question> queryByPop(Integer size);

    List<Question> queryByKey(String keyword);

    List<Question> queryByTopicId(Long topicId);

    List<Question> queryByTime();

    Question queryRandomByTopicId(Long topicId);
}
