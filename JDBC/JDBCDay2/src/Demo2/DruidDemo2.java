package Demo2;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        /**
         * 完成添加操作，给account表添加一条记录
         */
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1. 获取连接
            conn = JDBCUtils.getConnection();
            //2. 定义SQL
            String sql = "insert into account values (null,?,?)";
            //3. 获取pstmt对象
            ps = conn.prepareStatement(sql);
            //4. 给ps赋值
            ps.setString(1,"王");
            ps.setDouble(2,3000);
            //5. 执行sql
            int count = ps.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.Close(ps,conn);
        }

    }

}
