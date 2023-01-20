package com.bytedance.royal_douyin.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yumo
 * @Description: TODO
 * @DateTime: 2023/1/20 17:36
 **/
@MapperScan("com.bytedance.royal_douyin.mapper")
@Configuration
public class MybatisPlusConfig {
}
