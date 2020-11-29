package org.example.servlet;

import org.example.exaeption.AppException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet  extends AbstractBaseServlet{

    @Override
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("abc".equals(username)) {
            resp.sendRedirect("jsp/articleDetail.jsp");
        } else {
            throw new AppException("用户名密码错误");
        }
    }
}
