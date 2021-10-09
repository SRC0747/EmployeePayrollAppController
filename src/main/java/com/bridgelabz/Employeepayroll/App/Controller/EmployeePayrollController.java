package com.bridgelabz.Employeepayroll.App.Controller;

import com.bridgelabz.Employeepayroll.App.Entity.Employee;
import com.bridgelabz.Employeepayroll.App.Service.EmployeePayrollService;
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
        return EmployeePayrollService.employees();
    }

    @GetMapping(value = "/get-employee-by-id")
    public Employee getEmployeeById(@RequestParam int id){
        return employeePayrollService.getEmployeeById(id);
    }

    @GetMapping(value = "/get-employee-by-Name")
    public Employee getStudentByName(@RequestParam String name) {
        return employeePayrollService.getEmployeeByName(name);
    }

    @GetMapping(value = "/get-employee-by-salary")
    public Employee getEmployeeBySalary(@RequestParam long salary){
        return employeePayrollService.getEmployeeBySalary(salary);
    }

    @PostMapping(value = "/employee")
    public Employee addStudent(@RequestBody Employee employeeEntity) {
        return employeePayrollService.addEmployee(employeeEntity);
    }

    @PutMapping(value = "/employee")
    public Employee updateEmployee(@RequestBody Employee employeeEntity) {
        return employeePayrollService.updateEmployee(employeeEntity);
    }

    @DeleteMapping(value = "/employee")
    public String deleteEmployee(@RequestParam int id) {
        return employeePayrollService.deleteEmployee(id);
    }
}
