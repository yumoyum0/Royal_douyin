package com.bytedance.royal_douyin.service.impl;

import com.bytedance.royal_douyin.entity.User;

import com.bytedance.royal_douyin.exception.LocalRuntimeException;
import com.bytedance.royal_douyin.mapper.UserMapper;
import com.bytedance.royal_douyin.model.user.UserLoginModel;
import com.bytedance.royal_douyin.service.RedisService;
import com.bytedance.royal_douyin.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: yumo
 * @Description: TODO
 * @DateTime: 2023/1/20 17:28
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisService redisService;

    @Override
    public User getUserInfoById(Long userId,String token) {
        // TODO
        User user = userMapper.getUserById(userId);
        if (user == null){
            throw new LocalRuntimeException("找不到该用户");
        }
        return user;
    }

    @Override
    public UserLoginModel login(String username, String password) {
        // TODO
        return null;
    }

    @Override
    public UserLoginModel register(String username, String password) {
        // TODO
        return null;
    }
}
