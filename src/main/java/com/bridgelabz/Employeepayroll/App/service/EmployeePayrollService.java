package com.bridgelabz.Employeepayroll.App.service;

import com.bridgelabz.Employeepayroll.App.entity.Employee;
import com.bridgelabz.Employeepayroll.App.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {

    @Autowired
    private static EmployeeRepository employeeRepository;

    public static List<Employee> employees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        Optional<Employee> employeeEntity = employeeRepository.findById(id);
        if (employeeEntity.isPresent()){
            return employeeEntity.get();
        }
        return null;
    }

    public Employee getEmployeeByName(String name){
        Optional<Employee> employeeEntity = employeeRepository.findByName(name);
        if (employeeEntity.isPresent()){
            return employeeEntity.get();
        }
        return null;
    }

    public Employee getEmployeeBySalary(long salary){
        Optional<Employee> employeeEntity = employeeRepository.findBySalary(salary);
        if (employeeEntity.isPresent()){
            return employeeEntity.get();
        }
        return null;
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public String deleteEmployee(int id){
        Optional<Employee> employeeEntity = employeeRepository.findById(id);
        if(employeeEntity.isPresent()){
            employeeRepository.delete(employeeEntity.get());
            return "Employee Record is deleted successfully.";
        }
        return "Record does not exists with this id : " + id;
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
