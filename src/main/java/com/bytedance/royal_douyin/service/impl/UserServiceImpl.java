package com.bytedance.royal_douyin.service.impl;

import cn.hutool.core.codec.Base64;
import com.bytedance.royal_douyin.dataobject.UserDo;
import com.bytedance.royal_douyin.entity.User;
import com.bytedance.royal_douyin.enums.ErrorEnum;
import com.bytedance.royal_douyin.exception.LocalRuntimeException;
import com.bytedance.royal_douyin.mapper.UserMapper;
import com.bytedance.royal_douyin.model.user.UserLoginModel;
import com.bytedance.royal_douyin.service.RedisService;
import com.bytedance.royal_douyin.service.UserService;
import com.bytedance.royal_douyin.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: yumo
 * @Description: TODO
 * @DateTime: 2023/1/20 17:28
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    public static final String USER_ID_PREFIX = "userId:";

    private static final String TOKEN_PRE = "TOKEN:";
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisService redisService;

    @Override
    public User getUserInfoById(Long userId) {
        String redisKey = USER_ID_PREFIX+userId;
        User user;
        if (redisService.hasKey(redisKey)){
            user=(User) redisService.get(redisKey);
        }else {
            UserDo userDo = userMapper.getUserById(userId);
            if (userDo.getId() == null || !userDo.getId().equals(userId)){
                throw new LocalRuntimeException("user_id错误");
            }
            user = new User(userDo);
            redisService.set(redisKey,user);
        }
        return user;
    }

    @Override
    public UserLoginModel login(String username, String password) {
        UserDo userDo = userMapper.selectByUserName(username);
        if (userDo == null) throw new LocalRuntimeException(ErrorEnum.USERNAME_NOTFOUND_ERROR);
        // 将从数据库里得到的密码后与传入的password参数Base64加密后比较
        if (!userDo.getPassword().equals(Base64.encode(password)))
            throw new LocalRuntimeException(ErrorEnum.PASSWORD_ERROR);
        String token = jwtUtil.generateToken(username);
        return new UserLoginModel(userDo.getId(),token);
    }

    @Override
    public UserLoginModel register(String username, String password) {
        // 检查是否有相同用户名的用户，若有则抛出异常
        if (userMapper.selectByUserName(username) != null)
            throw new LocalRuntimeException(ErrorEnum.USERNAME_EXIT_ERROR);
        //将密码进行Base64加密
        String encodePwd = Base64.encode(password);
        userMapper.insert(new UserDo(username, encodePwd));
        UserDo userDo = userMapper.selectByUserName(username);
        String token = jwtUtil.generateToken(username);
        redisService.set(TOKEN_PRE + token,new User(userDo));
        return new UserLoginModel(userDo.getId(),token);
    }
}
