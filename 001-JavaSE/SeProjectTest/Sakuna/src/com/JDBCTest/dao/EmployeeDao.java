package com.JDBCTest.dao;

import com.JDBCTest.entity.Employee;

import java.util.List;

/**
 * 定义 专门用于部门表的dao增删改查
 */
public interface EmployeeDao {
    // 这里的抽象方法，全部用于操作部门表的增删改查
    // 增加员工,参数是一个Employee员工对象
    int addEmployee(Employee employee);
    // 删除员工：方法名的规范，约定：动作 + 目标 + 根据条件
    int delEmployee(Integer empId);
    // 更新数据
    int updateEmployee(Employee employee);
    // 查询数据
    List<Employee> getEmployee();
}
