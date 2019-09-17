package com.wander.manifold.controller;

import com.wander.manifold.pojo.Topic;
import com.wander.manifold.service.ITopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 胥珂铭 on 2019/7/31.
 */

@RestController
@RequestMapping("/manifold")
public class TopicController {

    @Resource(name="topicService")
    private ITopicService topicService;

    //查询子话题
    @GetMapping("/topic/son")
    public ResponseEntity<?> querySonTopic(Long topicId){
        List<Topic> topics=topicService.querySonTopic(topicId);
        return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
    }

    //查询根话题
    @GetMapping("/topic/root")
    public ResponseEntity<?> queryRoot(){
        Topic root=topicService.queryRoot();
        return new ResponseEntity<Topic>(root,HttpStatus.OK);
    }

    //查询祖先话题
    @GetMapping("/topic/ancestor")
    public ResponseEntity<?> queryAncestor(Long topicId){
        Topic ancestor=topicService.queryAncestor(topicId);
        return new ResponseEntity<Topic>(ancestor,HttpStatus.OK);
    }

    @GetMapping("/topic/keyword")
    public ResponseEntity<?> queryTopicByKeyword(String keyword){
        List<Topic> topics=topicService.queryTopicByKeyword(keyword);
        return new ResponseEntity<List<Topic>>(topics,HttpStatus.OK);
    }

    @GetMapping("/topic/questionId")
    public ResponseEntity<?> queryTopicIdByQuestionId(Long questionId){
        List<Long> topicIds=topicService.queryTopicIdByQuestionId(questionId);
        return new ResponseEntity<List<Long>>(topicIds,HttpStatus.OK);
    }


}
