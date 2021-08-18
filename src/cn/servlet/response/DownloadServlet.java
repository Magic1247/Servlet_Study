package cn.servlet.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");  // 从请求参数中获取文件名称
        ServletContext context = this.getServletContext();  // 获取ServletContest对象
        String fileRealPath = context.getRealPath("/img/" + filename);  // 使用ServletContest获取文件真实路径
        FileInputStream fs = new FileInputStream(fileRealPath); // 根据文件真实路径获取文件输入流
        response.setContentType(context.getMimeType(fileRealPath));  // 使用ServletContest获取文件MIME类型并设置返回ContentType 为当前文件MIME类型
        response.setHeader("content-disposition", "attachment;filename=" + filename); // 设置文件打开方式为附件形式
        byte[] bytes = new byte[1024]; // 获取字节数组
        int len;
        ServletOutputStream os = response.getOutputStream(); // 从返回对象中获取输出流
        while ((len = fs.read(bytes)) != -1) { // 读取本地文件内容
            os.write(bytes, 0, len); // 通过字节输出流输出当前下载的文件
        }
        fs.close();
    }
}
