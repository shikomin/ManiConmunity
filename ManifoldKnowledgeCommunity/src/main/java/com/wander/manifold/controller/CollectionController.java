package com.wander.manifold.controller;

import com.wander.manifold.pojo.Answer;
import com.wander.manifold.pojo.Collects;
import com.wander.manifold.service.ICollectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/7.
 */
@RestController
@RequestMapping("/manifold")
public class CollectionController {

    @Resource(name = "collectionService")
    private ICollectionService collectionService;

    @PostMapping("/collects")
    public ResponseEntity<?> add(String collectionName, Long uid) {
        Collects collects = new Collects();
        collects.setCollectionName(collectionName);
        collects.setCreateTime(new Date());
        collects.setUpdateTime(new Date());
        collects.setUid(uid);
        Integer res = collectionService.insert(collects);
        return new ResponseEntity<Integer>(res, HttpStatus.OK);
    }

    @GetMapping("/collects")
    public ResponseEntity<?> queryAll(Long uid){
        List<Collects> collectsList=collectionService.queryAll(uid);
        return new ResponseEntity<List<Collects>>(collectsList,HttpStatus.OK);
    }

    @PostMapping("/collects/addRela")
    public ResponseEntity<?> addRelate(Long collectionId,Long answerId){
        Integer res=collectionService.addRelate(collectionId,answerId);
        return new ResponseEntity<Integer>(res,HttpStatus.OK);
    }

    @GetMapping("/collects/queryAnswers")
    public ResponseEntity<?> queryAnswerByCollectId(Long collectionId){
        List<Answer> answers=collectionService.queryAnswerByCollectId(collectionId);
        return new ResponseEntity<List<Answer>>(answers,HttpStatus.OK);
    }
}
