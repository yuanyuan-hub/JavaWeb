package org.example.filter;

import org.example.model.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*
   配置用户统一回呼市管理的过滤器：匹配所有请求路径
   服务端资源：/Login不用校验Session，其他都要校验，如果不通过，返回401，响应内容随便
   前端资源：/jsp/校验Session，不通过定向到登录页面
   /js/,/static/,/view/全部不校验
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /*
     路径每次http请求匹配到过滤器路径时，会执行该过滤器的方法
     如果要往下执行，调用filterChain.doFilter(request,response)
     否则自行处理响应内容
     */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        String servletPath = req.getServletPath();//获取当前请求的服务路径
        //不需要登录允许访问；往下继续调用
        if(servletPath.startsWith("/js/")|| servletPath.startsWith("/static/")
         || servletPath.startsWith("/view/") || servletPath.equals("/login")) {
            chain.doFilter(request,response);
        } else {
            //获取session对象，没有就返回null
            HttpSession session = req.getSession(false);
            //验证用户是否登录,如果没有登录，还需要根据前端或后端做不同的处理
            if(session == null || session.getAttribute("user") == null) {
                //前端重定向到登录页面
                if(servletPath.startsWith("/jsp/")) {
                    resp.sendRedirect(basePsth(req)+"/view/login.html");
                } else {//返回401状态码
                    resp.setStatus(401);
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("application/json");
                    JSONResponse json = new JSONResponse();
                    json.setCode("LOG000");
                    json.setMessage("用户没有登录，不允许访问");
                    PrintWriter pw = resp.getWriter();
                    pw.println(JSONUtil.serialize(json));
                    pw.flush();;
                    pw.close();
                }
            } else {//敏感资源但已登录，允许继续执行
                chain.doFilter(request,response);
            }
        }
    }

    /**
     * 根据http请求，动态的获取访问路径，(服务路径之前的部分
     * @param req
     * @return
     */
    public static String basePsth(HttpServletRequest req) {
        String schema = req.getScheme();//http
        String host = req.getServerName();//主机IP或域名
        int port = req.getServerPort();//服务器端口号
        String contextPath = req.getContextPath();//获取应用上下文路径
        return schema + "://" + host + ":" +port +contextPath;
    }

    @Override
    public void destroy() {

    }
}
