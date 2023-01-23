package com.bytedance.royal_douyin.annotation;

import java.lang.annotation.*;

/**
 * @Author: yumo
 * @Description: 日志跟踪注解
 * @DateTime: 2023/1/23 14:18
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateLog {

    String value() default "";
}
