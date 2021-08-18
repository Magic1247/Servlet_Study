package cn.servlet.session.CheckCodeLogin;

import cn.servlet.request.login.bean.User;
import cn.servlet.request.login.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login2")
public class Login2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User loginUser = new User();
//        loginUser.setUserName(request.getParameter("username"));
//        loginUser.setPassword(request.getParameter("password"));
        String userCheckCode = request.getParameter("checkCode"); // 获取用户输入的验证码
        String checkCode_session = (String) request.getSession().getAttribute("checkCode_Session"); // 获取Session中的验证码
        request.getSession().invalidate();  // 删除Session
        System.out.println("user" + userCheckCode);
        System.out.println("session" + checkCode_session);
        if (userCheckCode.equals("")) { // 如果用户输入的验证码为空字符串，设置为null
            userCheckCode = null;
        }
        if (userCheckCode != null && checkCode_session != null) { // 判断用户输入的验证码与Session中的验证码不为空
            System.out.println("not null");
            if (userCheckCode.equalsIgnoreCase(checkCode_session)) { // 判断用户输入的验证码与Session中的验证码一致
                // 验证码一致
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
                    HttpSession session = request.getSession();
                    session.setAttribute("name", user.getUserName());
                    response.sendRedirect(request.getContextPath() + "/success.jsp");
                } else {
                    request.setAttribute("password_error", "用户名或密码错误，请重试");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            } else {
                // 验证码不一致
                request.setAttribute("cc_error", "验证码不一致，请重试");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } else {
            System.out.println("执行到了else");
            request.setAttribute("cc_error", "验证码不能为空");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
