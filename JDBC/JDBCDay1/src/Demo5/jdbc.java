package Demo5;

import Demo4.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 练习：
 *          需求：
 *                  1. 通过键盘录入用户名和密码
 *                  2. 判断用户是否登录成功
 */
public class jdbc {
    /**
     * 登录方法
     */
    public boolean login(String username, String password){

        if (username == null || password == null){
            return false;
        }
//      1. 初始化sql相关
        Connection conn =null;
        Statement stm = null;
        ResultSet rs = null;

        try {
//          1. 注册驱动+ 建立连接
            conn = JDBCUtils.getConection();
//          2. 获取执行对象
            stm = conn.createStatement();
//          3. 定义sql语句
            String sql = "select * from user where username = '"+ username +"' and password = '"+ password +"' ";
//          4. 执行sql语句
            rs = stm.executeQuery(sql);
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stm,conn);
        }
        return false;
    }
}
