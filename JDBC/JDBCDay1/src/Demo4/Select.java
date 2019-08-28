package Demo4;

import Demo3.Emp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select {
    public static void main(String[] args) {
        List<Emp> list = new Select().findAll();
        System.out.println(list);
    }

    //  定义一个方法，用来与数据库建立连接，并将emp表的内容，传递到emp对象中
    public static List<Emp> findAll() {
//      初始化 数据库 相关对象。
        Connection conn = null;//连接对象
        Statement sta = null;//执行对象
        ResultSet rs = null;//结果集对象
        List<Emp> list = new ArrayList<>();//存储emp的集合
        Emp emp = null;//初始化一个Emp类，下面直接复用。

        try {
//          1. 2. 注册驱动+ 获取连接
            conn = JDBCUtils.getConection();
//          3. 获取 sql执行对象
            sta = conn.createStatement();
//          4. 定义 sql语句
            String sql = "select * from emp";
//          5. 执行 sql语句，并将结果返回到 ResultSet集中
            rs = sta.executeQuery(sql);

//          遍历ResultSet集合
            while (rs.next()) {
//              数据导出
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

//              创建emp对象，复用
                emp = new Emp();
//              把字段名的值给emp的成员变量
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
//              把存储完成的emp对象，添加到list集合里。
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//          释放资源
            JDBCUtils.close(rs,sta,conn);
        }
        return list;//返回
    }
}
