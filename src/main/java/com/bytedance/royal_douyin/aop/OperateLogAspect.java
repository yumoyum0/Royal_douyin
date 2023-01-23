package com.bytedance.royal_douyin.aop;


import com.bytedance.royal_douyin.annotation.OperateLog;
import com.bytedance.royal_douyin.entity.TraceLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author: yumo
 * @Description: 日志跟踪切面
 * @DateTime: 2023/1/23 14:19
 **/
@Aspect
@Component
public class OperateLogAspect {
    private final static Logger logg = LoggerFactory.getLogger(OperateLogAspect.class);

    private final static Set<String> EXCLUDE_SET;

    static {
        EXCLUDE_SET = new HashSet<>();
        EXCLUDE_SET.add("password");
    }

    @Pointcut("@annotation(com.bytedance.royal_douyin.annotation.OperateLog)")
    public void operateLog(){
    }

    @Around("operateLog()&&@annotation(log)")
    public Object aroundMethod(ProceedingJoinPoint pjd, OperateLog log) throws Throwable {
        Object result = pjd.proceed();
        Map<String, Object> param = new HashMap<>();
        Object[] paramValues = pjd.getArgs();
        String[] paramNames = ((CodeSignature) pjd.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            if (EXCLUDE_SET.contains(paramNames[i])) continue;
            param.put(paramNames[i], paramValues[i]);
        }
        TraceLog traceLog = new TraceLog(log.value(),
                String.valueOf(pjd.getSignature()),
                param,
                result);
        logg.info(traceLog.toLogFormat(true));
        return result;
    }

}
