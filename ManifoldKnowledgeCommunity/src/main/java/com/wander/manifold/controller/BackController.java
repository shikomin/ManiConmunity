package com.wander.manifold.controller;

import com.wander.manifold.pojo.LayuiData;
import com.wander.manifold.pojo.User;
import com.wander.manifold.service.impl.BackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backuser")
public class BackController {

    @Autowired
    private BackService backService;

 /*   //查询所有用户信息
    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    public ResponseEntity<?> queryAll(){
        List<User> userList= backService.
        return  new ResponseEntity<>(userList,HttpStatus.OK);
    }*/

    //分页查询

    @GetMapping("/backUser")
    public ResponseEntity<?> queryAll(Integer page, Integer pageSize) {
        LayuiData layData = new LayuiData();
        Integer pagex = 1;
        Integer pageSizex = 10;
        if (page != null) {
            try {
                pagex = page;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (pageSize != null) {
            try {
                pageSizex = pageSize;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        List<User> cards = backService.query(pagex, pageSizex);
        layData.setCount(backService.count());
        layData.setCode(0);
        layData.setData(cards);
        return new ResponseEntity<LayuiData>(layData, HttpStatus.OK);
    }


    @PutMapping("/backUser")
    public ResponseEntity<?> updateUser(Long uid) {
        /*user.setNewDate(new Date());*/

         Integer i = backService.update(uid);
        return new ResponseEntity<>(i, HttpStatus.OK);


    }

    @GetMapping("/blockUser")
    public ResponseEntity<?> queryblock(Integer page, Integer pageSize) {
        LayuiData layData = new LayuiData();
        Integer pagex = 1;
        Integer pageSizex = 10;
        if (page != null) {
            try {
                pagex = page;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (pageSize != null) {
            try {
                pageSizex = pageSize;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        List<User> cards = backService.queryblock(pagex, pageSizex);
        layData.setCount(backService.count());
        layData.setCode(0);
        layData.setData(cards);
        return new ResponseEntity<LayuiData>(layData, HttpStatus.OK);
    }

    @PutMapping("/blockUser")
    public ResponseEntity<?> updatee(Long uid) {
        /*user.setNewDate(new Date());*/
        System.out.println("wel");

        Integer i = backService.update2(uid);
        return new ResponseEntity<>(i, HttpStatus.OK);


    }





}
