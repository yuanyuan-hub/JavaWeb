package org.example.servlet;

import org.example.exaeption.AppException;
import org.example.model.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class AbstractBaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求体的编码格式
        req.setCharacterEncoding("UTF-8");//设置请求体编码、
        //设置响应体
        resp.setCharacterEncoding("UTF-8");
        //设置响应体的数据类型，浏览器要采取什么方式执行
        resp.setContentType("application/json");

        //session会话管理，除登录注册接口，其他都需要登录后访问
        //req.getServletPath();获取请求服务路径
        //todo
        JSONResponse json = new JSONResponse();
        //
        try {
            Object data = process(req,resp);
            json.setSuccess(true);
            json.setData(data);
        } catch (Exception e) {
            //如何处理异常?JDBC异常SQLException，JSON处理的异常自定义异常返回错误消息
            e.printStackTrace();
            //json.setSuccess(false)不用设置了，表示业务执行成功
            String code = "UNKNOWN";
            String s = "服务器未知错误";
            if(e instanceof AppException) {
                code = ((AppException)e).getCode();
                s = e.getMessage();
            }
            json.setCode(code);
            json.setMessage(s);
        }

        PrintWriter pw= resp.getWriter();
        pw.println(JSONUtil.serialize(json));
        pw.flush();
        pw.close();
        //TODO
    }

    protected abstract Object process(HttpServletRequest req,HttpServletResponse resp) throws Exception;
}
