package com.wander.manifold.controller;

import com.wander.manifold.pojo.Prefer;
import com.wander.manifold.pojo.Question;
import com.wander.manifold.service.IPreferService;
import com.wander.manifold.service.IQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/7.
 * 记录用户行为
 */
@RestController
@RequestMapping("/manifold")
public class UserPreferController {
    /**概率区间数组*/
    private double[] probilityArry;

    @Resource(name="preferService")
    private IPreferService preferService;

    @Resource(name = "questionService")
    private IQuestionService questionService;

    @PostMapping("/user/prefer")
    public void addPrefer(Long uid, Long topicId) {
        Prefer prefer=preferService.queryByUidTopicId(uid,topicId);
        if(prefer!=null){
            preferService.update(uid,topicId);
        }else{
            preferService.insert(uid,topicId);
        }
    }

    @GetMapping("/user/prefer")
    public ResponseEntity<?> queryQuestionByPrefer(Long uid){
        List<Prefer> prefers=preferService.queryByUid(uid);

        probilityArry=new double[prefers.size()+1];
        probilityArry[0]=0;
        Long total=0L;
        for(int i=0;i<prefers.size();i++){
            total=total+prefers.get(i).getValue();
        }

        /**生成概率区间数组*/
        for(int i=1;i<probilityArry.length;i++){
            probilityArry[i]=probilityArry[i-1]+((double)prefers.get(i-1).getValue())/((double)total);
        }
        List<Question> questions=new ArrayList<>();
        Question question1=questionService.queryRandomByTopicId(prefers.get(getRandomIndex()).getTopicId());
        questions.add(question1);
        Question question2=questionService.queryRandomByTopicId(prefers.get(getRandomIndex()).getTopicId());
        questions.add(question2);
        Question question3=questionService.queryRandomByTopicId(prefers.get(getRandomIndex()).getTopicId());
        questions.add(question3);
        Question question4=questionService.queryRandomByTopicId(prefers.get(getRandomIndex()).getTopicId());
        questions.add(question4);
        Question question5=questionService.queryRandomByTopicId(prefers.get(getRandomIndex()).getTopicId());
        questions.add(question5);
        Question question6=questionService.queryRandomByTopicId(prefers.get(getRandomIndex()).getTopicId());
        questions.add(question6);
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    private int getRandomIndex(){
        double rd=Math.random();
        for(int i=0;i<probilityArry.length;i++){
            if(rd>=probilityArry[i]&&rd<=probilityArry[i+1]){
                return i;
            }
        }
        return 0;
    }

}
