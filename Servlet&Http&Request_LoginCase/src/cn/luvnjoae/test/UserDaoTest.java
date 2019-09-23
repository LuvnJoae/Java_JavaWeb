package cn.luvnjoae.test;

import cn.luvnjoae.dao.UserDao;
import cn.luvnjoae.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("superbaby");
        loginUser.setPassword("123");

        UserDao dao = new UserDao();
        User login = dao.login(loginUser);
        if (login == null) {
            System.out.println("用户不存在");
        }else {
            System.out.println(login);
        }

    }
}
