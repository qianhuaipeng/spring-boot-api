package com.alan.api.service.impl;

import com.alan.api.Application;
import com.alan.api.model.User;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: alan.peng
 * description:
 * date: create in 14:33 2018/11/3
 * modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void save(){
        User user = new User();
        user.setUsername("alan");
        user.setEmail("xiaoi.sasd");
        user.setPassword("123456");
        userService.save(user);


    }

    @Test
    public void findAllUserWithRole() {
        List<User> list =  userService.findAllUserWithRole();
        System.out.println(JSONObject.toJSONString(list));

    }

    @Test
    public void findDetailBy(){
        User user = userService.findDetailBy("id",3);
        System.out.println(user.toString());
    }


}
