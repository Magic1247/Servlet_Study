package cn.servlet.request.requestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo01")
public class RequestDemo01 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("对象创建");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod(); // 获取请求方式
        System.out.println(method);
        String contextPath = request.getContextPath();
        System.out.println(contextPath); // 获取项目虚拟路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath); // 获取Servlet路径
        String queryString = request.getQueryString();
        System.out.println(queryString); // 获取get请求请求参数
        String requestURI = request.getRequestURI();
        System.out.println(requestURI); // 获取requestURI
        StringBuffer requestURL = request.getRequestURL();
        String s = requestURI.toString();
        System.out.println(s); // 获取requestURI
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod(); // 获取请求方式
        System.out.println(method);
        String contextPath = request.getContextPath();
        System.out.println(contextPath); // 获取项目虚拟路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath); // 获取Servlet路径
        String queryString = request.getQueryString();
        System.out.println(queryString); // 获取get请求请求参数
        String requestURI = request.getRequestURI();
        System.out.println(requestURI); // 获取requestURI
        StringBuffer requestURL = request.getRequestURL();
        String s = requestURL.toString();
        System.out.println(s); // 获取requestURI
        String protocol = request.getProtocol();
        System.out.println(protocol); // 获取请求协议及版本号
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr); // 获取用户机IP地址
    }
}
