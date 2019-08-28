package JDBCTemplate;

import JDBCTemplate.domain.Emp;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;
import java.util.Map;



public class Demo2 {
    /**
     * Juint 单元测试
     *  可以让方法独立执行
     */

    //1. 获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 1. 修改1号数据的 salary 为10000
     */
    @Test
    public void test1(){
        //2. 定义sql
        String sql = "update emp set salary = 10000 where id = 1001 ";
        //3. 调用方法
        int count = template.update(sql);
        //打印
        System.out.println(count);
    }
    /**
     * 2. 添加一条记录
     */
    @Test
    public void test2(){
        //2. 定义sql
        String sql = "insert into emp (id, ename, dept_id) values (?, ?, ?)";
        template.update(sql,1015,"郭靖",10);
    }
    /**
     * 3. 删除添加的记录
     */
    @Test
    public void test3(){
        String sql = "delete from emp where id = ?";
        template.update(sql,1015);
    }
    /**
     * 4. 查询id为1的记录，将其封装为Map集合
     *  注意：
     *      这个方法只能同时  封装一行
     */
    @Test
    public void test4(){
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }
    /**
     * 5. 查询所有记录，将其封装为List
     *  注意：
     *      将多条记录中的每一条记录，封装成Map集合，再将Map装载到List中。
     */
    @Test
    public void test5(){
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }
    /**
     * 6. 查询所有记录，并将其封装成Emp的List集合
     *  注意：
     *      这里的Emp，其实就是一个JavaBean
     *      记住常用的类 BeanPropertyRowMapper
     */
    @Test
    public void test6(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    /**
     * 7. 查询总记录数
     *  注意：
     *      queryForObject 一般用来查询一些聚合函数
     */
    @Test
    public void test7(){
        String sql = "select count(id) from emp";
        Long aLong = template.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }
}
