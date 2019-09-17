package com.wander.manifold.service;

    import com.wander.manifold.pojo.User;
import java.util.List;



    public interface IBackService {


        public List<User> query(Integer page, Integer pageSize);

        List<User> queryblock(Integer start, Integer size);

        public Integer count();

         Integer add(User user);

         Integer update(Long uid);

         Integer update2(Long uid);

}
