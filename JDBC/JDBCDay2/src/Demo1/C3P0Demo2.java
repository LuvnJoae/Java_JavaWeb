package Demo1;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0演示2
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1. 创建 数据库连接池 对象
        DataSource ds = new ComboPooledDataSource("otherc3p0");//使用制定名称的c3p0配置
        //2. 获取 连接对象
        Connection conn = ds.getConnection();
    }
}
