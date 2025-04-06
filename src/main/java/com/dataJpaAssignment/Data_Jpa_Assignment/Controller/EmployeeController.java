package com.dataJpaAssignment.Data_Jpa_Assignment.Controller;

import com.dataJpaAssignment.Data_Jpa_Assignment.Dao.EmployeeRepo;
import com.dataJpaAssignment.Data_Jpa_Assignment.Model.EmployeeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo repo;

    @PostMapping("/bulk")
    public ResponseEntity<List<EmployeeRegistration>> addEmployees() {
        List<EmployeeRegistration> employees = Arrays.asList(
                new EmployeeRegistration("Sai", "12281", "Software Developer"),
                new EmployeeRegistration("Joy", "32000", "Software Engineer"),
                new EmployeeRegistration("Ravi", "45000", "Senior Developer"),
                new EmployeeRegistration("Maya", "25000", "Data Analyst"),
                new EmployeeRegistration("Anil", "50000", "Project Manager")
        );
        List<EmployeeRegistration> savedEmployees = (List<EmployeeRegistration>) repo.saveAll(employees);
        return new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
    }

    @GetMapping("/getsecondlargest")
    public ResponseEntity<String> getSecondLargest() {
        String secondLargestSalary = repo.findSecondLargestSalary();
        return new ResponseEntity<>("Second largest salary is: " + secondLargestSalary, HttpStatus.OK);
    }
}
