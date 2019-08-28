package JDBCTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

/**
 * 使用JDBCTemplate进行CRUD
 */
public class Demo1 {
    public static void main(String[] args) {
        //1. 导入jar包
        //2. 创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3. 调用方法
        String sql = "update account set balance = 6000 where id = ?";
        int count = template.update(sql, 3);
        //打印影响的行数
        System.out.println(count);
    }
}
