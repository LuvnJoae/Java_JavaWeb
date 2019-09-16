package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestDemo1", urlPatterns = "/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("dePost Hello");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求方式 Get
        String method = request.getMethod();
        System.out.println(method);
        //2. 获取虚拟目录 /JavaWeb
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3. 获取Servlet路径 /requestDemo1
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4. 获取get方式请求参数 name=zhangsan
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5. 获取请求Url /JavaWeb/requestDemo1
        StringBuffer requestURL = request.getRequestURL();  // URL是整个链接
        System.out.println(requestURL);
        String requestURI = request.getRequestURI();  // URI是从虚拟根路径开始的
        System.out.println(requestURI);
        //6. 获取协议及版本 HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7. 获取客户机的IP地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
