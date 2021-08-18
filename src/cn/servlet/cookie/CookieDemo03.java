package cn.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo03")
public class CookieDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg", "Hello!");
//        cookie.setMaxAge(300); // 设置cookie有效期为300秒 如果设置为负数，关闭浏览器后自动删除cookie
        cookie.setMaxAge(0); // 删除cookie
        cookie.setPath("/"); // 设置cookie共享权限，/ 代表当前服务器下所有项目共享该cookie
//        cookie.setDomain(""); // 设置一个字符串的一级域名，则该域名下的子域名都可以共享该cookie
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
