package cn.provinceMVCDemo.web.servlet;

import cn.provinceMVCDemo.service.ProvinceService;
import cn.provinceMVCDemo.service.impl.ProvinceServiceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProvinceService provinceService = new ProvinceServiceimpl(); // 创建serviceimpl对象
        response.setContentType("application/json;charset=utf-8"); // 设置返回数据为json
        String data = provinceService.findAllRedis(); // 调用查询方法
        response.getWriter().write(data); // 返回数据
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
