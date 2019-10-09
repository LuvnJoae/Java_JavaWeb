package cn.luvnjoae.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseDemo3", urlPatterns = "/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //设置编码，在获取流之前设置编码 统一为 utf-8
//        response.setContentType("utf-8");
//
//        //再告诉浏览器，服务器发送数据所采用的的编码格式 是utf-8,这样服务器就会根据这个编码格式来解码
//        response.setHeader("content-type", "text/html;charset=utf-8");

        //直接根据响应头名称设置该响应头
        response.setContentType("text/html;charset=utf-8");

        //1. 获取字符输出流
        PrintWriter pw = response.getWriter();
        //2. 输出
        pw.write("你好");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
