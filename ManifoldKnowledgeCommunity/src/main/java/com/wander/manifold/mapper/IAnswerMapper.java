package com.wander.manifold.mapper;

import com.wander.manifold.pojo.Answer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/4.
 */
@Repository("answerMapper")
public interface IAnswerMapper {

    Integer insert(Answer answer);

    List<Answer> query();

    List<Answer> queryByQuestionId(Long questionId);

    Answer queryByUid(Long uid);

}
