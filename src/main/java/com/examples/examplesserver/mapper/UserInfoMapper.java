package com.examples.examplesserver.mapper;

import com.examples.examplesserver.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    UserInfo selectUserInfo(String username);
}
