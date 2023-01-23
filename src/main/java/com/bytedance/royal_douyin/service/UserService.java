package com.bytedance.royal_douyin.service;

import com.bytedance.royal_douyin.entity.User;
import com.bytedance.royal_douyin.model.user.UserLoginModel;

/**
 * @Author: yumo
 * @Description: TODO
 * @DateTime: 2023/1/20 17:27
 **/
public interface UserService {
    User getUserInfoById(Long userId);
    UserLoginModel login(String username, String password);
    UserLoginModel register(String username, String password);
}
