package org.example.servlet;

import org.example.exaeption.AppException;

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
        try {
            req.setCharacterEncoding("UTF-8");//设置请求体编码
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");

            //session会话管理，除登录注册接口，其他都需要登录后访问
            //req.getServletPath();获取请求服务路径
            //todo

            //调用子类重写的方法
            process(req,resp);
        } catch (Exception e) {
            //如何处理异常?JDBC异常SQLException，JSON处理的异常自定义异常返回错误消息
            e.printStackTrace();
            String s = "服务器未知错误";
            if(e instanceof AppException) {
                s = e.getMessage();
            }
            PrintWriter pw= resp.getWriter();
            pw.println(s);
            pw.flush();
            pw.close();
            //TODO
        }
    }

    protected abstract void process(HttpServletRequest req,HttpServletResponse resp) throws Exception;
}
