package com.bridgelabz.Employeepayroll.App.repository;

import com.bridgelabz.Employeepayroll.App.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByName(String name);

    Optional<Employee> findBySalary(long salary);
}
