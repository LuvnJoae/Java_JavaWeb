package Demo6;

import Demo4.JDBCUtils;

import java.sql.*;

public class jdbc2 {
    /**
     * 登录方法，使用PreparedStatement
     * @param username
     * @param password
     * @return
     */
    public boolean login2(String username, String password){

        if (username == null || password == null){
            return false;
        }
//      1. 初始化sql相关
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
//          1. 注册驱动+ 建立连接
            conn = JDBCUtils.getConection();
//          2. 定义sql语句
            String sql = "select * from user where username = ? and password = ?";
//          3. 获取执行对象
            ps = conn.prepareStatement(sql);
//          4. 赋值
            ps.setString(1,username);
            ps.setString(2,password);

//          4. 执行sql语句
            rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,ps,conn);
        }
        return false;
    }
}
