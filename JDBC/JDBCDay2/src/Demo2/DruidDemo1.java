package Demo2;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid 演示
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        //1. 导入jar包
        //2. 定义配置文件
        //3. 加载配置文件
        Properties pro = new Properties();
        InputStream is  = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //4. 获取 数据库连接池 对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //5. 获取 连接 对象
        Connection conn = ds.getConnection();
        // 打印
        System.out.println(conn);
    }
}
