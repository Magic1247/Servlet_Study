package cn.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SessionDemo01")
public class SessionDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("msg", "Hello");
        Cookie cookie = new Cookie("JSESSIONID", session.getId());  // Session依赖与Cookie实现，通过设置JSEEIONID(cookie)的有效期可以达到session持久化保存的目的
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        System.out.println(session);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
