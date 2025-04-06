package com.dataJpaAssignment.Data_Jpa_Assignment.Dao;

import com.dataJpaAssignment.Data_Jpa_Assignment.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    //find by custom query
    List<Student>  findBystd_Branch(String branch);
}
