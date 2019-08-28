package Demo1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.Executor;

public class JDBC {
    public static void main(String[] args) throws Exception {
//      1. 导入相应数据库的jar包
//      2. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
//      3. 获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","root");
//      4. 定义SQL语句
        String sql = "update account set balance = 500 where id =1";
//      5. 获取执行SQL语句的对象
        Statement statement = conn.createStatement();
//      6. 执行SQL
        int count = statement.executeUpdate(sql);
//      7. 处理结果
        System.out.println(count);
//      8. 释放资源
        statement.close();
        conn.close();

    }
}

