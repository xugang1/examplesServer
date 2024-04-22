package com.examples.examplesserver.service;

import com.examples.examplesserver.entity.UserInfo;
import com.examples.examplesserver.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserInfo(String username) {
        return userInfoMapper.selectUserInfo(username);
    }
}
