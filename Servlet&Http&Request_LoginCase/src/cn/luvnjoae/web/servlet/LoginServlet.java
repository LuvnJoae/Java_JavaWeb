package cn.luvnjoae.web.servlet;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 设置编码
        req.setCharacterEncoding("utf-8");
        /**
         * 一般方式
         *      通过get、set，先将参数拿出来，再放入User对象里去。根据名称，一个个放。
         */
//        //2. 获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        //3. 封装user对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        /**
         * 通过BeanUtils方式
         *      通过BeanUtils的populate方法，将所有参数封成Map，再把这个Map 的内容放入到User对象里去，全部一次性操作。
         */
        //2. 获取所有请求参数
        Map<String, String[]> map = req.getParameterMap();
        //3. 创建User对象
        User loginUser = new User();
        //3.1 使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4. 调用UserDao的login方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        //5. 判断user是否存在
        if (user == null) {
//            System.out.println("登录失败，用户名不存在或密码错误");
            // 登录失败
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        } else {
            // 登录成功
            // 存储数据
            req.setAttribute("user", user);
            req.getRequestDispatcher("successServlet").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
