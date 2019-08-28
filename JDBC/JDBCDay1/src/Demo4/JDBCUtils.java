package Demo4;

import java.io.FileReader;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    /**
     * 获取连接  不好的写法
     * @return 连接对象
     *
     * 之所以不好，是因为这种方法虽然是可行的，也实现了动态参数。但是，实际操作起来，并没有比之前更加简便
     * 例如：
     *      原： conn = DriverManager.getConnection("jdbc:mysql:///db3","root","root");
     *      现： conn = JDBCUtils.getConnection("jdbc:mysql:///db3","root","root")
     *      可以看出来，还是要写一堆url和账号密码，并没有更简便。
     */
    public static Connection getConnection2(String url, String user, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection( url,user,password );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return conn;
        }
    }

    /**
     * 获取连接  好的写法  +  注册驱动
     * @return 连接对象
     *
     * 通过文件读取，来进行参数的赋值，这样，当需要修改url或账户密码时，一行代码都不需要动，改配置文件即可。
     *   文件的读取，只需要读取一次即可拿到这些值，并一直使用不需要再次读取，除非进行更改，提高读取效率。
     *      使用 静态代码块。 随着类的加载而加载，只会加载一次。
     */
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        //读取资源文件，获取值
        Properties pro = null;
        try {
            //1. 创建Properties集合类
            pro = new Properties();
            //2. 加载文件
            /**
             * 路径这里可以写绝对路径，但是可移植性太差了。
             *  获取src路径下的文件的方式  ---》 ClassLoader 类加载器
             */
            String path = JDBCUtils.class.getClassLoader().getResource("jdbc.properties").getPath();
            pro.load(new FileReader(path));
//            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
//            pro.load(is);
//            pro.load(new FileReader("D:\\Java projects\\Basic\\JDBCDay1\\jdbc.properties"));
            //3. 获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4. 注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }


    /**
     * 释放资源 重载形式
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源 重载形式
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源 重载形式
     * @param ps
     * @param conn
     */
    public static void close(PreparedStatement ps, Connection conn){
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源 重载形式
     * @param rs
     * @param ps
     * @param conn
     */
    public static void close(ResultSet rs,PreparedStatement ps, Connection conn){
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
