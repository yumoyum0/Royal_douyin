package com.bytedance.royal_douyin.enums;

public enum ErrorEnum {

    INTERNAL_ERROR(5000,"内部错误，请联系管理员修复"),

    UNKNOWN_ERROR(5001, "其他错误，请联系管理员排查"),

    SESSION_ERROR(5003,"会话不存在"),
    TOKEN_ERROR(5003,"token错误"),
    SESSION_TIMEOUT(5004,"会话过期"),
    NULL_POINTEREXCEPTION_ERROR(5005,"空指针异常"),

    PASSWORD_ERROR(5006,"密码错误"),

    USERNAME_NOTFOUND_ERROR(5007,"用户名不存在"),

    USERNAME_EXIT_ERROR(5008,"用户名已存在");



    private Integer errCode;
    private String errMsg;

    ErrorEnum(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }
}
