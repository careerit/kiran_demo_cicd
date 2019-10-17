package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/Employee", produces = { "application/json+mdm", MediaType.APPLICATION_JSON_VALUE })
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(
            value ="/{id}",
            method = RequestMethod.GET,
            consumes = {"application/json", MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Employee> getEmployee(
            @PathVariable String id) {
        return ResponseEntity.ok(employeeDAO.getEmployeeById(id));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            consumes = {"application/json", MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<Employee>> getEmployee() {
        return ResponseEntity.ok(employeeDAO.getEmployeeList());
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = {"application/json", MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Employee> create(
            @RequestBody Employee value,
            HttpServletRequest request) {
                employeeDAO.createEmployee(value);
                return ResponseEntity.ok(value);
    }
}

