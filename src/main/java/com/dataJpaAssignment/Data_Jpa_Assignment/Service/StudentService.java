package com.dataJpaAssignment.Data_Jpa_Assignment.Service;

import com.dataJpaAssignment.Data_Jpa_Assignment.Dao.StudentRepo;
import com.dataJpaAssignment.Data_Jpa_Assignment.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;


    public List<Student> getDataByBranch(String branch){

       return repo.findBystd_Branch(branch);
    }

}
