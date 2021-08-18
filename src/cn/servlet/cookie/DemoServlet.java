package cn.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String ReallastTime = null;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastTime")) {
                    ReallastTime = cookie.getValue();
                    ReallastTime = URLDecoder.decode(ReallastTime, "utf-8");
                    cookie.setMaxAge(0);
                    break;
                }
            }
        }
        response.setContentType("text/html;charset=utf-8");
        if (ReallastTime != null) {
            response.getWriter().write("上次访问时间" + ReallastTime);
            Cookie cookie = new Cookie("lastTime", getRealDate());
            cookie.setMaxAge(6000);
            response.addCookie(cookie);
        } else {
            response.getWriter().write("欢迎首次访问");
            Cookie cookie = new Cookie("lastTime", getRealDate());
            cookie.setMaxAge(6000);   // 先设置持久化存储时间再返回！！！
            response.addCookie(cookie);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private String getRealDate() throws IOException {
        Date date = new Date(); // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY年MM月dd日 HH:mm:ss"); // 定义日期format方式
        String formatdate = dateFormat.format(date);// 格式化当前时间
        String encodetime = URLEncoder.encode(formatdate, "utf-8");
        return encodetime;
    }
}
