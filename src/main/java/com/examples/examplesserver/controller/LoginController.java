package com.examples.examplesserver.controller;

import com.examples.examplesserver.entity.Result;
import com.examples.examplesserver.entity.User;
import com.examples.examplesserver.entity.UserInfo;
import com.examples.examplesserver.service.LoginService;
import com.examples.examplesserver.utils.EncryptUtil;
import com.examples.examplesserver.utils.JWTTokenUtil;
import com.examples.examplesserver.utils.ResultHandler;
import com.examples.examplesserver.utils.UserInfoUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserInfoUtil userInfoUtil;


    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        String username = user.getUsername();
        EncryptUtil.encrypt(user);
        return loginService.login(user, username);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        EncryptUtil.encrypt(user);
        return loginService.register(user, username);
    }

    @GetMapping("/public/user")
    public Result userInfo() {
        UserInfo userInfo = userInfoUtil.getUserInfo();
        return ResultHandler.success(userInfo);
    }


}
