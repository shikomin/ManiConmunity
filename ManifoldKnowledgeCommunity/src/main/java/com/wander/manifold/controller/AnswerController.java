package com.wander.manifold.controller;

import com.wander.manifold.pojo.Answer;
import com.wander.manifold.pojo.Question;
import com.wander.manifold.pojo.User;
import com.wander.manifold.service.IAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/4.
 */
@RestController
@RequestMapping("/manifold")
public class AnswerController {

    @Resource(name = "answerService")
    private IAnswerService answerService;

    @PostMapping("/answer")
    public ResponseEntity<?> addQuestion(Long questionId, Long uid, String content) {
        Answer answer = new Answer();
        Question question = new Question();
        question.setQuestionId(questionId);
        answer.setQuestion(question);
        User user = new User();
        user.setUid(uid);
        answer.setUser(user);
        answer.setContent(content);
        Integer res = answerService.add(answer);
        if (res > 0)
            return new ResponseEntity<String>("ok", HttpStatus.OK);
        else
            return new ResponseEntity<String>("fail", HttpStatus.OK);
    }

    @GetMapping("/answer/byquesionid")
    public ResponseEntity<?> queryByQuestionId(Long questionId) {
        List<Answer> answers = answerService.queryByQuestionId(questionId);
        return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
    }


}
