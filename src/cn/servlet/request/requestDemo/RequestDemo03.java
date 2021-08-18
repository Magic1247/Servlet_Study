package cn.servlet.request.requestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo03")
public class RequestDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("referer");  // 获取请求头中的referer值
        System.out.println(referer);
        if (referer.contains("/study")) {   // 判断请求是否来自当前项目
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("正确访问");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("not found");
        }
    }
}
