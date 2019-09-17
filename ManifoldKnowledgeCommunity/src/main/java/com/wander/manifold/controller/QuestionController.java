package com.wander.manifold.controller;

import com.wander.manifold.pojo.Question;
import com.wander.manifold.pojo.User;
import com.wander.manifold.service.IQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/2.
 */
@RestController
@RequestMapping("/manifold")
public class QuestionController {

    @Resource(name = "questionService")
    private IQuestionService questionService;

    @PostMapping("/question")
    public ResponseEntity<?> addQuestion(String title, String questionDesc, String selectedTopics, Long uid) {
        Question question = new Question();
        question.setTitle(title);
        question.setQuestionDesc(questionDesc);
        User user = new User();
        user.setUid(uid);
        question.setUser(user);
        question.setCreateTime(new Date());
        question.setStatus(1);
        Integer res = questionService.addQuestion(question);
        //线程暂停，等待新问题插入数据库
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (res > 0) {
            question = questionService.queryByTitle(title);
            //插入关系
            if (question != null) {
                String[] topics = selectedTopics.split(",");
                for (int i = 0; i < topics.length; i++) {
                    questionService.addRelation(Long.parseLong(topics[i].substring(topics[i].indexOf("-") + 1)), question.getQuestionId());
                }
            }

            return new ResponseEntity<Long>(question.getQuestionId(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Long>(-1L, HttpStatus.OK);
        }

    }

    @GetMapping("/question/chktitle")
    public ResponseEntity<?> checkTitle(String title) {
        Question question = questionService.queryByTitle(title);
        if (question != null)
            return new ResponseEntity<Long>(question.getQuestionId(), HttpStatus.OK);
        else
            return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @GetMapping("/question/querybyid")
    public ResponseEntity<?> queryById(Long questionId) {
        Question question = questionService.queryById(questionId);
        if (question != null)
            return new ResponseEntity<Question>(question, HttpStatus.OK);
        else {
            question.setQuestionId(-1L);
            return new ResponseEntity<Question>(question, HttpStatus.OK);
        }
    }

    @GetMapping("/question/pop")
    public ResponseEntity<?> queryByPop(Integer size) {
        List<Question> questions = questionService.queryByPop(size);
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    @GetMapping("question/key")
    public ResponseEntity<?> queryByKey(String keyword) {
        List<Question> questions = questionService.queryByKey(keyword);
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    @GetMapping("question/topic")
    public ResponseEntity<?> queryByTopicId(Long topicId) {
        List<Question> questions = questionService.queryByTopicId(topicId);
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    @GetMapping("question/time")
    public ResponseEntity<?> queryByTime() {
        List<Question> questions = questionService.queryByTime();
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

}
