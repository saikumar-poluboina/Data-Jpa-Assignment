package com.dataJpaAssignment.Data_Jpa_Assignment.Dao;

import com.dataJpaAssignment.Data_Jpa_Assignment.Model.UserReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRegDao extends JpaRepository<UserReg,Integer> {

}
