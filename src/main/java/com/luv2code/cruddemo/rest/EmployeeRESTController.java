package com.luv2code.cruddemo.rest;


import com.luv2code.cruddemo.dao.EmployeeDAO;
import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.service.EmployeeService;
import jakarta.persistence.EntityManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

//    entity

    private EmployeeService employeeService;


//    constructor
    public EmployeeRESTController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

//    findall method api
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

//    get by id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null){
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }
        return theEmployee;
    }

//    add new student
    @PostMapping("/employees")
    Employee CreateEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(null);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
}
