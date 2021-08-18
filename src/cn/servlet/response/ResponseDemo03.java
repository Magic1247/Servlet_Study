package cn.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo03")
public class ResponseDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        ServletOutputStream sos = response.getOutputStream();
        sos.write("字节流输出".getBytes("UTF-8"));    // 一个Servlet对象中不能同时存在字符流和字节流
//        PrintWriter pw = response.getWriter();
//        pw.write("Hello,Response!");
//        pw.write("<h1>Hello,World!</h1>");
//        pw.write("<h1>你好，世界!</h1>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
