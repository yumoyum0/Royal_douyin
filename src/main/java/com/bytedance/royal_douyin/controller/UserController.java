package com.bytedance.royal_douyin.controller;

import com.bytedance.royal_douyin.entity.User;
import com.bytedance.royal_douyin.model.user.UserLoginModel;
import com.bytedance.royal_douyin.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: yumo
 * @Description: 用户Controller
 * @DateTime: 2023/1/20 17:22
 **/
@RestController
@RequestMapping("/douyin/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 获取登录用户的信息
     */
    @GetMapping("/")
    public User getUserInfo(Long userId,String token){
        return userService.getUserInfoById(userId,token);
    }

    /**
     * 注册
     */
    @GetMapping("/register")
    public UserLoginModel register(String username, String password){
        return userService.register(username,password);
    }

    /**
     * 登录
     */
    @GetMapping("/login")
    public UserLoginModel login(String username,String password){
        return userService.login(username,password);
    }
}
