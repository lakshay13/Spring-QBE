package org.suri.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Component
public class Employee {

    private String employeName;
    private String employeePosition;
    @Id
    private int employeeId;

    public Employee() {}

    public Employee(String name, String position, int empId) {
        this.employeName = name;
        this.employeePosition = position;
        this.employeeId = empId;
    }

    public String getName() {
        return employeName;
    }

    public void setName(String name) {
        this.employeName = name;
    }

    public String getPosition() {
        return employeePosition;
    }

    public void setPosition(String position) {
        this.employeePosition = position;
    }

    public int getEmpId() {
        return employeeId;
    }

    public void setEmpId(int empId) {
        this.employeeId = empId;
    }
}
