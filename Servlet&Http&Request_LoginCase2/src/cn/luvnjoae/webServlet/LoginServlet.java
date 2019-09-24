package cn.luvnjoae.webServlet;

import cn.luvnjoae.dao.UserDao;
import cn.luvnjoae.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    //小插曲，自己想的统计登录人数，以及失败与成功人数
    private static int count = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置编码
        request.setCharacterEncoding("utf-8");
        /**
         * 一般获取参数方式
         */
        //2. 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3. 封装User对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        /**
         * 通过BeanUtils
         */
//        //2. 获取请求参数
//        Map<String, String[]> map = request.getParameterMap();
//        //3. 封装User对象
//        User loginUser = new User();
//        try {
//            BeanUtils.populate(loginUser, map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        //4. 调用UserDao的login方法
        UserDao userDao = new UserDao();
        User resultUser = userDao.login(loginUser);
        request.setAttribute("resultUser", resultUser);

        //小插曲，自己想的统计登录人数，以及失败与成功人数(只在服务器启东时生效，关闭则清零)
        System.out.println("总登录人数：" + ++count);

        //5. 显示查询结果
        if (resultUser == null) {
            request.getRequestDispatcher("/failServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
