package com.bytedance.royal_douyin.exception;


import com.bytedance.royal_douyin.enums.ErrorEnum;
import lombok.Data;

/**
 * @author yumo
 */
@Data
public class LocalRuntimeException extends RuntimeException {

    //默认错误
    private ErrorEnum error;

    //默认错误
    public LocalRuntimeException(String message) {
        super(message);
    }

    public LocalRuntimeException(ErrorEnum errorEnum) {
        super(errorEnum.getErrMsg());
        this.error = errorEnum;
    }

    public LocalRuntimeException(ErrorEnum error, String message) {
        super(message);
        this.error = error;
    }
    public LocalRuntimeException(ErrorEnum error, String message, Throwable cause) {
        super(message, cause);
        this.error = error;
    }

    public LocalRuntimeException(ErrorEnum error, Throwable cause) {
        super(cause);
        this.error = error;
    }
}
