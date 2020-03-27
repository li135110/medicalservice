package com.tk.medical.oauth2.entity;

/**
 *  响应状态码
 */
public enum ResultCode {
    //处理成功
    SUCCESSTWO(200, "处理成功"),
    SUCCESS(1),

    //处理失败
    FAILEDTWO(500, "处理失败"),
    FAILED(0),

    //未登录
    NOT_LOGIN(401, "未登录"),

    //未激活
    NOT_ACTIVED(402, "未激活"),

    //访问拒绝
    ACCESS_DENIED(403, "访问拒绝"),

    //数据库错误
    DB_ERROR(503, "数据库错误"),

    //参数错误
    PARAM_PARAMETER_ERROR(501, "参数错误"),

    //参数为空
    PARAM_PARAMETER_IS_NULL(502, "参数为空"),
    ;

    private int code;

    private String message;

    ResultCode(int code) {
        this.code = code;
    }
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String message) {
        return String.format(this.message, message == null ? "" : message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
