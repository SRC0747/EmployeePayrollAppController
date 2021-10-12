package com.bridgelabz.Employeepayroll.App.DTO;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class EmployeeDTO {
    private String name;
    private long salary;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
