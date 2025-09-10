package com.JDBCTest.mapper.impl;

import com.JDBCTest.entity.Employee;
import com.JDBCTest.mapper.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class EmployeeRowMapperImpl implements RowMapper<Employee> {

    @Override
    public Employee parseData(ResultSet resultSet) {
        // 创建实体类对象
        Employee employee = new Employee();
        try {

            // 存储每一行的数据到 实体类中
            employee.setEmpId(resultSet.getInt(1));
            employee.setEmpName(resultSet.getString(2));
            employee.setEmpAge(resultSet.getInt(3));
            employee.setEmpAddress(resultSet.getString(4));
            employee.setEmpSex(resultSet.getString(5));
            Date sqlDate = resultSet.getDate(6);
            // 转为 util类的Date类
            java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
            employee.setEmpBirthday(utilDate);
            employee.setEmpScore(resultSet.getDouble(7));
            employee.setDepId(resultSet.getInt(8));
            employee.setEmpInfo(resultSet.getString(9));
            employee.setEmpStatus(resultSet.getInt(10));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 把这个对象返回
        return employee;
    }
}
