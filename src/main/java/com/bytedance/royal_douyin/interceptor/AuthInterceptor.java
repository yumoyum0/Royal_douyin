package com.bytedance.royal_douyin.interceptor;

import cn.hutool.system.UserInfo;
import com.bytedance.royal_douyin.entity.User;
import com.bytedance.royal_douyin.enums.ErrorEnum;
import com.bytedance.royal_douyin.exception.LocalRuntimeException;
import com.bytedance.royal_douyin.service.RedisService;
import com.bytedance.royal_douyin.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: yumo
 * @Description: JWT鉴权拦截器
 * @DateTime: 2023/1/23 11:21
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private RedisService redisService;

    private static final String TOKEN_PRE = "TOKEN:";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        if (token == null)
            throw new LocalRuntimeException(ErrorEnum.NOT_LOGIN_ERROR);
        User user = (User) redisService.get(TOKEN_PRE+token);
        if (user == null || !jwtUtil.validateToken(token,user))
            throw new LocalRuntimeException(ErrorEnum.TOKEN_ERROR);
        return true;
    }
}
