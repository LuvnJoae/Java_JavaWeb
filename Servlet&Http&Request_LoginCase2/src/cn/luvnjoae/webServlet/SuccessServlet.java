package cn.luvnjoae.webServlet;

import cn.luvnjoae.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    private static int successCount = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取request域中共享的对象
        User resultUser = (User) request.getAttribute("resultUser");

        //1. 设置编码（回复response的编码，刚才的是request的编码）
        response.setContentType("text/html;charset=utf-8");
        //输出
        response.getWriter().write("登录成功" + resultUser.getUsername() + "欢迎你！");
        System.out.println("登录成功的人数：" + ++successCount);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
