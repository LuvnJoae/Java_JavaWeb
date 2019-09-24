package cn.luvnjoae.webServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/failServlet")
public class FailServlet extends HttpServlet {
    private static int failCount = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置编码（回复response的编码，刚才的是request的编码）
        response.setContentType("text/html;charset=utf-8");
        //输出
        response.getWriter().write("登录失败！用户名或密码错误");
        System.out.println("登录失败人数：" + ++failCount);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
