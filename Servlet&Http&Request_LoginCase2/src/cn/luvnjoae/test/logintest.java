package cn.luvnjoae.test;

import cn.luvnjoae.dao.UserDao;
import cn.luvnjoae.domain.User;
import org.junit.Test;

public class logintest {
    @Test
    public void test() {
        User loginUser = new User();
        loginUser.setUsername("zhangyi");
        loginUser.setPassword("123");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        if (user == null) {
            System.out.println("null");
        } else {
            System.out.println(user.toString());
        }
    }
}
