package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {

    static final String INSERT_EMPLOYEE = "INSERT INTO employee(\n" +
                "\temp_name, emp_id, emp_company)\n" +
            "\tVALUES (?, ? , ?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee getEmployeeById(final String _id) {

        final String EMP_QRY = "select * from employee where emp_id = ?";
        return jdbcTemplate.queryForObject(EMP_QRY, new Object[] {_id}, new EmployeeRowMapper());
    }

    public List<Employee> getEmployeeList() {

        final String EMP_QRY = "select * from employee";
        return jdbcTemplate.query(EMP_QRY, new EmployeeRowMapper());
    }

    public void createEmployee(final Employee employee) {
        jdbcTemplate.update(INSERT_EMPLOYEE, employee.getName(), employee.getEmployeeId(), employee.getCompany());
    }


}
