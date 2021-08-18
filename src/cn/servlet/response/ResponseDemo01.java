package cn.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo01...");
//        response.setStatus(302);
//        response.setHeader("location","/study/responseDemo02");
//        response.sendRedirect("/study/responseDemo02");  // 使用sendRedirect 方法实现重定向，只需要指定跳转的服务器资源
        System.out.println(request.getContextPath() + "/responseDemo02");
        response.sendRedirect(request.getContextPath() + "/responseDemo02");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
