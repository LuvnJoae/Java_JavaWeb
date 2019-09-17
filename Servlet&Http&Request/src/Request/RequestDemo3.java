package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 获取请求体  ---请求参数
 */
@WebServlet(name = "RequestDemo3", urlPatterns = "/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取字符流
        BufferedReader reader = request.getReader();
        //2. 读取数据
        String line = null;
        while ( (line = reader.readLine()) != null) {
            System.out.println(line);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
