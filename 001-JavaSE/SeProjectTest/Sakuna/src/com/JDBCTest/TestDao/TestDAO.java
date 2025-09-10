package com.JDBCTest.TestDao;

import com.JDBCTest.BaseDao.BaseDao;
import com.JDBCTest.dao.EmployeeDao;
import com.JDBCTest.dao.Impl.EmployeeDaoImpl;
import com.JDBCTest.entity.Employee;
import com.JDBCTest.mapper.RowMapper;
import com.JDBCTest.mapper.impl.EmployeeRowMapperImpl;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TestDAO {
    // 创建DAO对象，获取DAO对象
    BaseDao baseDao = new BaseDao();
    @Test
    public void TestDaoV1(){
        // 调用增删改方法
        String sql = "insert into employee values (?,?,?,?,?,?,?,?,?,?)";
        int resRow = baseDao.modifyDataAny(sql, new Object[]{18, "许嵩", 22, "河南洛阳", "男", "2024-03-06 15:59:59", 99.99, 2, "歌手", 1});
        System.out.println("resRow = " + resRow);
    }

    // 查询数据
    @Test
    public void TestDaoV2(){
        String sql = "select * from employee";
        // 定义通过多态的方式创建rowmapper对象，使用接口中的方法，这样更换他的实现类，代码不用改变，支持热插拔。
        RowMapper rowMapper = new EmployeeRowMapperImpl();
        // 通过baseDao中的查询方法获取数据
        List list = baseDao.queryDataAny(sql, rowMapper);
        for (Object o : list) {
            System.out.println("o = " + o);
        }
    }
    // 查询数据总数
    @Test
    public void TestDaoV3() throws SQLException {
        String sql = "select count(*) from employee";
        // 定义通过多态的方式创建rowmapper对象，使用接口中的方法，这样更换他的实现类，代码不用改变，支持热插拔。
        RowMapper rowMapper = new EmployeeRowMapperImpl();
        // 通过baseDao中的查询方法获取数据
        int sum = baseDao.getScalaData(sql);
        System.out.println("sum = " + sum);
    }
    // 添加数据
    @Test
    public void addEmployee(){
        // 创建一个DAO对象
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        // 创建一个员工对象
        Employee employee = new Employee(20,"hanser",21,"河南新乡","女",null,97.65,2,"演员",2);
        // 调用添加员工的方法
        int resRow = employeeDao.addEmployee(employee);
        System.out.println("resRow = " + resRow);
    }
}
