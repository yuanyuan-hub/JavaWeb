package org.example.model;
/*
http响应JSON数据，前后端统一约定好的json格式
响应状态码都是200，进入ajxa的success方法来使用
{success:true,data:XXXX}
{success:false,code:XXX,message:xxx}
 */
public class JSONResponse {
    //业务操作是否成功的标识
    private boolean success;
    //业务操作的消息码，一般来说，出现错误时的错误码才有意义，给开发人员看定位问题
    private String code;
    //业务操作错误信息，给用户看
    private String message;
    //业务数据，业务操作成功时，给前端ajax success方法使用，解析响应json，渲染网页内容
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JSONResponse{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
