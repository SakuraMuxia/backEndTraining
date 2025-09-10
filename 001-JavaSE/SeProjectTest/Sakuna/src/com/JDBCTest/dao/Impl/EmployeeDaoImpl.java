package com.JDBCTest.dao.Impl;

import com.JDBCTest.BaseDao.BaseDao;
import com.JDBCTest.dao.EmployeeDao;
import com.JDBCTest.entity.Employee;
import com.JDBCTest.mapper.RowMapper;
import com.JDBCTest.mapper.impl.EmployeeRowMapperImpl;

import java.util.List;

public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {
    // 新增员工sql
    @Override
    public int addEmployee(Employee employee) {
        // 定义sql
        String sql = "insert into employee values (?,?,?,?,?,?,?,?,?,?)";
        // 定义参数列表
        Object[] args = new Object[]{employee.getEmpId(),employee.getEmpName(),employee.getEmpAge(),employee.getEmpAddress(),employee.getEmpSex(),employee.getEmpBirthday(),employee.getEmpScore(),employee.getDepId(),employee.getEmpInfo(),employee.getEmpStatus()};
        // 调用BaseDao中新增的方法
        int resRow = this.modifyDataAny(sql,args);
        return resRow;
    }

    @Override
    public int delEmployee(Integer empId) {
        return 0;
    }

    @Override
    public int updateEmployee(Employee employee) {
        return 0;
    }

    @Override
    public List<Employee> getEmployee() {
        return null;
    }
}
