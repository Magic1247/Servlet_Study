package cn.servlet.request.login.service;

import cn.servlet.request.login.bean.User;
import cn.servlet.request.login.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        UserDao userDao = new UserDao();
        if (userDao.regist(user) == 0) {
            response.getWriter().println("<h1>Registration success</h1>");
            response.getWriter().println("<a href=\"http://121.4.104.195/login/\">Return to login page</a>");

        } else {
            response.getWriter().println("<h1>registration falied,Please check the registration information you entered</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
