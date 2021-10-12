package com.bridgelabz.Employeepayroll.App.controller;

import com.bridgelabz.Employeepayroll.App.DTO.EmployeeDTO;
import com.bridgelabz.Employeepayroll.App.entity.Employee;
import com.bridgelabz.Employeepayroll.App.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeePayrollController {
    // CRUD
    //read
    //creating
    //updating
    //deleting

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = "/employees")
    public List<Employee> employees(){
        return employeePayrollService.employees();
    }

    @GetMapping(value = "/get-employee-by-id")
    public Employee getEmployeeById(@RequestParam int id){
        return employeePayrollService.getEmployeeById(id);
    }

    @GetMapping(value = "/get-employee-by-Name")
    public Employee getEmployeeByName(@RequestParam String name) {
        return employeePayrollService.getEmployeeByName(name);
    }

    @GetMapping(value = "/get-employee-by-salary")
    public Employee getEmployeeBySalary(@RequestParam long salary){
        return employeePayrollService.getEmployeeBySalary(salary);
    }

    @PostMapping(value = "/employee")
    public Employee addEmployee(@RequestBody Employee employeeEntity) {
        return employeePayrollService.addEmployee(employeeEntity);
    }

    @PutMapping(value = "/employee")
    public Employee updateEmployee( @PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        return employeePayrollService.updateEmployee(id,employeeDTO);
    }

    @DeleteMapping(value = "/employee")
    public String deleteEmployee(@RequestParam int id) {
        return employeePayrollService.deleteEmployee(id);
    }
}
