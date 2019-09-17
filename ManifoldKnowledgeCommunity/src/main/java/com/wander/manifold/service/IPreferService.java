package com.wander.manifold.service;

import com.wander.manifold.pojo.Prefer;

import java.util.List;

/**
 * Created by 胥珂铭 on 2019/8/7.
 */
public interface IPreferService {

    Prefer queryByUidTopicId(Long uid, Long topicId);

    Integer insert(Long uid,Long topicId);

    Integer update(Long uid,Long topicId);

    List<Prefer> queryByUid(Long uid);
}
