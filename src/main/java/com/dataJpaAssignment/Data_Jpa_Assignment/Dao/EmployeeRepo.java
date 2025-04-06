package com.dataJpaAssignment.Data_Jpa_Assignment.Dao;

import com.dataJpaAssignment.Data_Jpa_Assignment.Model.EmployeeRegistration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeRegistration , Integer> {
    @Query(value = "SELECT MAX(tbl_salary) FROM tab_employeeinfo WHERE tbl_salary < (SELECT MAX(tbl_salary) FROM tab_employeeinfo)", nativeQuery = true)
    String findSecondLargestSalary();
}
