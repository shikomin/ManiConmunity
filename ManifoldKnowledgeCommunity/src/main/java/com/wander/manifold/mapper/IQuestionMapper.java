package com.wander.manifold.mapper;

import com.wander.manifold.pojo.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/2.
 */

@Repository("questionMapper")
public interface IQuestionMapper {

    Integer insert(Question question);

    Integer insertRelation(Long topicId,Long questionId);

    Question queryByTitle(String title);

    Question queryById(Long questionId);

    List<Question> queryByPop(Integer size);

    List<Question> queryByKey(String keyword);

    List<Question> queryByTopicId(Long topicId);

    List<Question> queryByTime();

    Question queryRandomByTopicId(Long topicId);

}
