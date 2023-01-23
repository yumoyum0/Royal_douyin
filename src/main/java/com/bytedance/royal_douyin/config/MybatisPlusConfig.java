package com.bytedance.royal_douyin.config;


import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @Author: yumo
 * @Description: TODO
 * @DateTime: 2023/1/20 17:36
 **/
@MapperScan("com.bytedance.royal_douyin.mapper")
@Configuration
public class MybatisPlusConfig {

    /**
     * 实现时间字段自动添加及更新
     */
    @Bean
    public MetaObjectHandler metaObjectHandler(){
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                this.strictInsertFill(metaObject,"createTime", LocalDateTime.class,LocalDateTime.now());
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                this.strictUpdateFill(metaObject,"updateTime", LocalDateTime.class,LocalDateTime.now());
            }
        };
    }
}
