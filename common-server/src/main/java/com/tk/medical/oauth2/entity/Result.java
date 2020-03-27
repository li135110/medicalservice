package com.tk.medical.oauth2.entity;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String message;
    private Object data;
    //消息
    private static String query = "查询成功";
    private static String insert = "添加成功";
    private static String update = "修改成功";
    private static String delete = "删除成功";
    private static String failed = "失败";

    public Result() {
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 查询成功
     * @param data
     * @return
     */
    public static Result querySuccess(Object data){
        return new Result(ResultCode.SUCCESS.getCode(),query,data);
    }

    /**
     * 新增成功
     * @param data
     * @return
     */
    public static Result insertSuccess(Object data){
        return new Result(ResultCode.SUCCESS.getCode(),insert,data);
    }


    /**
     * 更新成功
     * @param data
     * @return
     */
    public static Result updateSuccess(Object data){
        return new Result(ResultCode.SUCCESS.getCode(),update,data);
    }

    /**
     * 删除成功
     * @param data
     * @return
     */
    public static Result deleteSuccess(Object data){
        return new Result(ResultCode.SUCCESS.getCode(),delete,data);
    }

    /**
     * 处理异常
     * @param data
     * @return
     */
    public static Result resultFailed(Object data){
        return new Result(ResultCode.FAILED.getCode(),failed,data);
    }
}
