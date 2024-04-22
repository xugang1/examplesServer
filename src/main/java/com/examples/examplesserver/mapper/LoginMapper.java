package com.examples.examplesserver.mapper;

import com.examples.examplesserver.entity.User;
import com.examples.examplesserver.entity.UserInfo;
import com.examples.examplesserver.utils.ResultHandler;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper
public interface LoginMapper {

    User login(User user);

    int insert(User user);

    int insertUserInfo(UserInfo userInfo);
}
