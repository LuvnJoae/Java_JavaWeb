package Demo7;

import Demo4.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务管理
 */
public class JDBCDemo7 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            //1. 注册驱动 + 获取连接
            conn = JDBCUtils.getConection();
            /**
             * 开启事务
             */
            conn.setAutoCommit(false);
            //2. 定义SQL
            //2.1 张三 - 500
            String sql1 = "update account set balance = balance - ? where id = ?";
            //2.2 李四 + 500
            String sql2 = "update account set balance = balance + ? where id = ?";
            //3. 获取执行对象
            ps1 = conn.prepareStatement(sql1);
            ps2 = conn.prepareStatement(sql2);
            //4. 设置参数
            ps1.setDouble(1,500);
            ps1.setInt(2,1);

            ps2.setDouble(1,500);
            ps2.setInt(2,2);

            //5. 执行sql
            ps1.executeUpdate();
            ps2.executeUpdate();
            /**
             * 提交事务
             */
            conn.commit();

        } catch (SQLException e) {
            /**
             * 事务回滚
             */
            try {
                if (conn != null){ //先保证一下conn 不是空。
                    conn.rollback();
                }
            } catch (Exception e1) { //抓的异常应该为大的。
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps1,conn);
            JDBCUtils.close(ps2,null);
        }
    }
}
