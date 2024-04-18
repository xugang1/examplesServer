package com.examples.examplesserver.mapper;

import com.examples.examplesserver.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RedisMapper {

    User selectUser(String username);
}
