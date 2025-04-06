package com.dataJpaAssignment.Data_Jpa_Assignment.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_employeeinfo")
public class EmployeeRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "tbl_employeeName")
    private String employeeName;
    @Column(name = "tbl_salary")
    private String salary ;
    public  EmployeeRegistration(){}

    public EmployeeRegistration (String employeeName, String salary, String designation) {

        this.employeeName = employeeName;
        this.salary = salary;
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "tab_designation")
    private String designation;

}

