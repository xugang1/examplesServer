package com.examples.examplesserver.service;

import com.examples.examplesserver.entity.Result;
import com.examples.examplesserver.entity.User;
import com.examples.examplesserver.mapper.LoginMapper;
import com.examples.examplesserver.utils.JWTTokenUtil;
import com.examples.examplesserver.utils.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public Result login(User user) {
        User login = loginMapper.login(user);
        if(login != null) {
            String token = JWTTokenUtil.createToken(user.getUsername());
            return ResultHandler.success(token);
        }
        return ResultHandler.customResult(401, null, "当前登录用户不存在");
    }

    public Result register(User user) {
        try {
            loginMapper.insert(user);
            return ResultHandler.success("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultHandler.success("注册失败");
        }
    }
}
