package com.bytedance.royal_douyin.exception;


import com.bytedance.royal_douyin.enums.ErrorEnum;
import com.bytedance.royal_douyin.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * @author: 風楪fy
 * @create: 2021-09-19 16:29
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(LocalRuntimeException.class)
    public Result localRunTimeException(LocalRuntimeException e) {
        log.error("异常", e);
        if (e.getError() != null) {
            return Result.failure(e.getError());
        } else {
            return Result.failure(e.getMessage());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handlerValidationException(MethodArgumentNotValidException e) {
        log.error("参数校验异常", e);
        String messages = e.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("\n"));
        return Result.failure(messages);
    }

    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerException(NullPointerException e) {
        log.error("空指针异常", e);
        return Result.failure(ErrorEnum.NULL_POINTEREXCEPTION_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public Result runtimeException(Exception e) {
        log.error("其他异常", e);
        return Result.failure(ErrorEnum.UNKNOWN_ERROR);
    }
}
