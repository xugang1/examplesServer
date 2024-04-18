package com.examples.examplesserver.controller;

import com.examples.examplesserver.entity.Result;
import com.examples.examplesserver.entity.User;
import com.examples.examplesserver.service.RedisService;
import com.examples.examplesserver.utils.EncryptUtil;
import com.examples.examplesserver.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;


    @GetMapping("/user/{username}")
    public Result getUserInfo(@PathVariable String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(username);
        EncryptUtil.encrypt(user);
        return redisService.getUserInfo(user.getUsername());
    }
}
