package com.wander.manifold.service;

import com.wander.manifold.pojo.Answer;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/4.
 */

public interface IAnswerService {

    Integer add(Answer answer);

    List<Answer> query();

    List<Answer> queryByQuestionId(Long questionId);

    Answer queryByUid(Long uid);
}
