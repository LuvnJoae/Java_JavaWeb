package cn.luvnjoae.dao;

import cn.luvnjoae.domain.User;
import cn.luvnjoae.utils.JDBCUtils;
import com.alibaba.druid.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表的类
 */
public class UserDao {
    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法  查询是否有 用户名与密码 相符合的用户
     * @param loginUser
     * @return user对象
     */
    public User login(User loginUser) {
        try {
            //1. 编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2. 调用query方法
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),
                     loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
