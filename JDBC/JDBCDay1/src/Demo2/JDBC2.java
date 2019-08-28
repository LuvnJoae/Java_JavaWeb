package Demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC2 {
    public static void main(String[] args) {
//      如果把变量放在try里面，就是局部变量，finally就访问不到，所以先在外面定义一个空变量。
        Statement sta = null;
        Connection conn = null;
        try {
//          1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
//          2. 定义sql
            String sql = "insert into account values(null, '王五',3000)";
//          3. 获取 数据库连接对象Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
//          4. 获取sql执行对象 statement
            sta = conn.createStatement();
//          5. 执行sql
            int count = sta.executeUpdate(sql);
//          6. 处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//          先用后关，后用先关
//          这里加if判断的目的，如果connection对象创建的过程中出现错误，就会直接跳到catch，而不会继续执行statement，
//          那么最后finally里，sta是null的，就会报空指针异常，所以先进行判断，不是空，再释放。
            if (sta != null){
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
//          和statement一样
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
