package com.wander.manifold.service;

import com.wander.manifold.pojo.Answer;
import com.wander.manifold.pojo.Collects;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/7.
 */
public interface ICollectionService {

    Integer insert(Collects collects);

    List<Collects> queryAll(Long uid);

    Integer addRelate(Long collectionId,Long answerId);

    List<Answer> queryAnswerByCollectId(Long collectionId);
}
