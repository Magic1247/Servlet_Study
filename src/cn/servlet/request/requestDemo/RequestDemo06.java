package cn.servlet.request.requestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo06")
public class RequestDemo06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Enumeration<String> names = request.getParameterNames();
//        System.out.println(request.getParameter("hobby"));
        while (names.hasMoreElements()) {    // 迭代器里不要多次使用next方法！！！！！！！
            String name = names.nextElement();
            System.out.println(name);
            System.out.println(request.getParameter(name));
        }
        System.out.println("=========================================");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keys = parameterMap.keySet();  // 获取参数map的keyset单列集合
        for (String s : keys) {   // 遍历keys集合
            for (String values : parameterMap.get(s)) {   // 使用key获取对应的参数String[] 并遍历该参数数组
                System.out.println(s + ":" + values);
                System.out.println("================");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
