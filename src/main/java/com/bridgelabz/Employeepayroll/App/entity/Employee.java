package com.bridgelabz.Employeepayroll.App.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
    @Id
    private int id;
    private String name;
    private long salary;
}
