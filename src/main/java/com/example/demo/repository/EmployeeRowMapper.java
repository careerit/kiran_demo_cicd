package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setName(resultSet.getString("emp_name"));
        employee.setCompany(resultSet.getString("emp_company"));
        employee.setEmployeeId(resultSet.getString("emp_id"));
        return employee;
    }
}
