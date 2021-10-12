package com.bridgelabz.Employeepayroll.App.service;

import com.bridgelabz.Employeepayroll.App.DTO.EmployeeDTO;
import com.bridgelabz.Employeepayroll.App.entity.Employee;
import com.bridgelabz.Employeepayroll.App.exception.CustomException;
import com.bridgelabz.Employeepayroll.App.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class for the business logic for Employeepayroll App Controller service
 *
 * @author Sampriti Roy Chowdhury
 * @version 0.0.1
 * @since 11-10-2021
 */

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method for getting all the students from database
     * @return list of {@link Employee Entity}
     */

    public  List<Employee> employees(){
        return employeeRepository.findAll();
    }

    /**
     * Method for getting employee by its id
     * @param id unique identifier for record
     * @return singular {@link Employee Entity}
     */

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

    /**
     *
     * @param EmployeeDTO
     * @return
     */

    public Employee addEmployee(Employee employee){
        //Employee employee = new Employee();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        modelMapper.map(employeeDTO, employee);
        return employeeRepository.save(employee);
    }

    public String deleteEmployee(int id){
        Optional<Employee> employeeEntity = employeeRepository.findById(id);
        if(employeeEntity.isPresent()){
            employeeRepository.delete(employeeEntity.get());
            return "Employee Record is deleted successfully.";
        }
        //return "Record does not exists with this id : " + id;
        throw new CustomException("Record does not exist with this id:"+id);
    }

    public Employee updateEmployee(int id, EmployeeDTO employeeDTO){
        Optional<Employee> optionalEmployeeEntity = employeeRepository.findById(id);
        if(optionalEmployeeEntity.isPresent()) {
            Employee employeeEntity = optionalEmployeeEntity.get();
            employeeEntity.setId(employeeDTO.getId());
            employeeEntity.setName(employeeDTO.getName());
            employeeEntity.setSalary(employeeDTO.getSalary());
            return employeeRepository.save(employeeEntity);
        }
        return null;
    }
}
