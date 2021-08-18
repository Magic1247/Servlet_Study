package cn.servlet.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo04")
public class ResponseDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();  // 获取ServletContext对象，共享数据至整个web应用
//        context.setAttribute("msg", "hehe");

        String web = context.getRealPath("/index.jsp");// 获取web目录下文件的真实路径
        System.out.println(web);
        String WEB_INF = context.getRealPath("/WEB-INF/web.xml"); // 获取WEB-INF目录下的文件真实路径
        System.out.println(WEB_INF);
        String src = context.getRealPath("/WEB-INF/classer/druid.properties"); // 获取src目录下文件的真实路径
        System.out.println(src);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
