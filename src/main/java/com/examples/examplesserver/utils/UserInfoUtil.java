package com.examples.examplesserver.utils;

import com.examples.examplesserver.entity.UserInfo;
import com.examples.examplesserver.service.UserInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Component
public class UserInfoUtil {

    @Autowired
    private UserInfoService userInfoService;

    public UserInfo getUserInfo() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String token = request.getHeader("Authorization");
        String username = JWTTokenUtil.parserToken(token);
        return userInfoService.getUserInfo(username);
    }
}
