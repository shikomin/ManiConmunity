package com.wander.manifold.service.impl;

import com.wander.manifold.mapper.ICollectionMapper;
import com.wander.manifold.pojo.Answer;
import com.wander.manifold.pojo.Collects;
import com.wander.manifold.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/7.
 */
@Service("collectionService")
public class CollectionServiceImpl implements ICollectionService {

    @Autowired
    private ICollectionMapper collectionMapper;

    @Override
    public Integer insert(Collects collects) {
        return collectionMapper.insert(collects);
    }

    @Override
    public List<Collects> queryAll(Long uid) {
        return collectionMapper.queryAll(uid);
    }

    @Override
    public Integer addRelate(Long collectionId, Long answerId) {
        return collectionMapper.addRelate(collectionId,answerId);
    }

    @Override
    public List<Answer> queryAnswerByCollectId(Long collectionId) {
        return collectionMapper.queryAnswerByCollectId(collectionId);
    }
}
