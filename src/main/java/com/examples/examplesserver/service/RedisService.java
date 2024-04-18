package com.examples.examplesserver.service;

import com.examples.examplesserver.entity.Result;
import com.examples.examplesserver.entity.User;
import com.examples.examplesserver.mapper.RedisMapper;
import com.examples.examplesserver.utils.RedisUtil;
import com.examples.examplesserver.utils.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisMapper redisMapper;

    public Result getUserInfo(String username) {
        Object user = null;
        if(redisUtil.containKey(username)) {
            user = redisUtil.getValue(username);
        } else {
            user = redisMapper.selectUser(username);
            if(user == null) {
                return ResultHandler.success("该用户不存在");
            } else {
                redisUtil.cacheValue(username, user);
            }
        }
        return ResultHandler.success(user);

    }
}
