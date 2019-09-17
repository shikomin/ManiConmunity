package com.wander.manifold.service.impl;

import com.wander.manifold.mapper.IAnswerMapper;
import com.wander.manifold.pojo.Answer;
import com.wander.manifold.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/4.
 */
@Service("answerService")
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    private IAnswerMapper answerMapper;

    @Override
    public Integer add(Answer answer) {
        return answerMapper.insert(answer);
    }

    @Override
    public List<Answer> query() {
        return answerMapper.query();
    }

    @Override
    public List<Answer> queryByQuestionId(Long questionId) {
        return answerMapper.queryByQuestionId(questionId);
    }

    @Override
    public Answer queryByUid(Long uid) {
        return answerMapper.queryByUid(uid);
    }
}
