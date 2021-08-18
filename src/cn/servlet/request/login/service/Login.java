package cn.servlet.request.login.service;

import cn.servlet.request.login.bean.User;
import cn.servlet.request.login.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User loginUser = new User();
//        loginUser.setUserName(request.getParameter("username"));
//        loginUser.setPassword(request.getParameter("password"));
        User loginUser = new User();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(loginUser, map);    /*
            Apache BeanUtils工具类，简化参数封装对象过程,新建空对象,获取参数map,使用该工具类封装对象
            使用该工具类映射，前端入参的键必须是javaBean中的成员变量名完全一致
            */
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(loginUser);
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        if (user != null) {
            request.setAttribute("name", user.getUserName());
            request.getRequestDispatcher("/SuccessServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/FailServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
