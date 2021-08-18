package cn.servlet.request.requestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo02")
public class RequestDemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()){
//            String s = headerNames.nextElement();
//            System.out.println(s+":"+request.getHeader(s));
//        }
        String header = request.getHeader("user-agent");
        if (header.contains("Postman")) {
            System.out.println("postman");
        } else if (header.contains("Chrome")) {
            System.out.println("Chrome YYDS");
        } else {
            System.out.println("shit");
        }
    }
}
