package org.example.exaeption;
/*
自定义异常类：业务代码抛自定义异常或其他异常
自定义异常返回给定错误码，其他异常返回其他错误码

 */
public class AppException extends RuntimeException{

    //给前端返回json字符串，保存错误码
    private String code;

    public AppException(String code,String message) {
//        super(message);
//        this.code = code;
        this(code,message,null);
    }

    public AppException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
