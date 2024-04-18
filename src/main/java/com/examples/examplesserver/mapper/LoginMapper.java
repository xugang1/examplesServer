package com.examples.examplesserver.mapper;

import com.examples.examplesserver.entity.User;
import com.examples.examplesserver.utils.ResultHandler;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    User login(User user);
}
