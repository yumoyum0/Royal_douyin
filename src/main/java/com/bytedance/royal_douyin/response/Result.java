package com.bytedance.royal_douyin.response;

import com.bytedance.royal_douyin.enums.ErrorEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yumo
 * @create: 2023/1/20 17:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    /**
     * 状态码，0-成功，其他值-失败
     */
    @JsonProperty("status_code")
    private Integer statusCode;
    /**
     * 返回状态描述
     */
    @JsonProperty("status_msg")
    private String statusMsg;
    private T data;

    public static <T> Result success(T data) {
        return new Result<T>(0, null, data);
    }

    public static <Void> Result failure(String errMsg) {
        return new Result(1, errMsg, null);
    }
    public static <Void> Result failure(ErrorEnum error) {
        return new Result(error.getErrCode(),error.getErrMsg(), null);
    }

}
