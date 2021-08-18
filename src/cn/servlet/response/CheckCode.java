package cn.servlet.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCode")
public class CheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR); // 获取BufferedImage对象，传图片宽、高及图片类型
        Graphics graphics = image.getGraphics();  // 获取画笔对象
        graphics.setColor(Color.PINK); // 设置画笔颜色
        graphics.fillRect(0, 0, width, height); // 填充背景色
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            char c = str.charAt(random.nextInt(str.length()));
            graphics.drawString(c + "", width / 5 * i, height / 2);
            sb.append(c);
        }
        HttpSession session = request.getSession();  // 获取Sesion对象
        session.setAttribute("checkCode_Session", sb.toString()); // 将验证码字符串写入Session对象中
        System.out.println(sb.toString());
        // 绘制干扰线
        for (int i = 1; i <= 10; i++) {
            int x = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x, y, x2, y2);
        }

        ImageIO.write(image, "jpg", response.getOutputStream());


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
