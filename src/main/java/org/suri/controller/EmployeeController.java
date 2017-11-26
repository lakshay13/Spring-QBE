package org.suri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.suri.repository.EmployeeRepository;
import org.suri.model.Employee;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/emp/add", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmpDetails(@RequestParam(value="id", required = true) int empId,
                                                  @RequestParam(value="name", required = true) String empName,
                                                  @RequestParam(value="position", required = true) String empPosition) {

        Employee employee = new Employee(empName, empPosition, empId);
        employeeRepository.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
}
