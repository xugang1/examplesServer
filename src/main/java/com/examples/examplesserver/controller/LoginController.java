package com.examples.examplesserver.controller;

import com.examples.examplesserver.entity.Result;
import com.examples.examplesserver.entity.User;
import com.examples.examplesserver.service.LoginService;
import com.examples.examplesserver.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("login")
    public Result login(@RequestBody User user) {
        EncryptUtil.encrypt(user);
        return loginService.login(user);
    }
}
