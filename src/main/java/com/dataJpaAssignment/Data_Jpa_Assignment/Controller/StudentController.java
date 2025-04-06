package com.dataJpaAssignment.Data_Jpa_Assignment.Controller;

import com.dataJpaAssignment.Data_Jpa_Assignment.Dao.StudentRepo;
import com.dataJpaAssignment.Data_Jpa_Assignment.Model.Student;
import com.dataJpaAssignment.Data_Jpa_Assignment.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentRepo repo;

    @Autowired
    StudentService service;

    @PostMapping("/saveData")
    public String saveData(@RequestBody List<Student> student){
        repo.saveAll(student);
        return "Success";
    }

    @GetMapping("getData")
    public List<Student> getStudentData(){
        return repo.findAll();
    }



    @GetMapping("/findBy/{branch}")
    public ResponseEntity<List<Student>> getDataByBranch(@PathVariable String branch){
        List<Student> list = service.getDataByBranch(branch);
        return ResponseEntity.ok(list);
    }


}
