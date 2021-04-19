package com.tregulov.spring.rest.contorller;

import com.tregulov.spring.rest.entity.Employee;
import com.tregulov.spring.rest.exception_handling.EmployeeIncorrectData;
import com.tregulov.spring.rest.exception_handling.NoSuchEmployeeException;
import com.tregulov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if(employee == null) {
            throw new NoSuchEmployeeException("There is not employee with ID: " + id + " in DataBase");
        }
        return employee;
    }


}
