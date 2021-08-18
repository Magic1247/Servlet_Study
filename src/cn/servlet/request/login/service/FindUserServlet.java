package cn.servlet.request.login.service;

import cn.servlet.request.login.dao.UserDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        UserDao userDao = new UserDao();
        Map<String, Object> map = new HashMap<>();
        response.setContentType("application/json;charset=utf-8");
        if (userDao.findUser(userName)) {
            map.put("userexist", true);
            map.put("msg", "此用户名太受欢迎，请修改后重试");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(), map);
        } else {
            map.put("userexist", false);
            map.put("msg", "用户名可用");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(), map);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
