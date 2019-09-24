package cn.luvnjoae.dao;

import cn.luvnjoae.domain.User;
import cn.luvnjoae.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    //1. 声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @return
     */
    public User login(User loginUser) {

        try {
            //1. 编写Sql
            String sql = "select * from user where username = ? and password = ?";
            //2. 调用query方法
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
//            e.printStackTrace(); // 当在数据库中查不到相关User信息时，即为 null 时，会抛出异常，这里把它暂时屏蔽掉，好显示人数统计。
            return null;
        }

    }

}
