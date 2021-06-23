package com.nagarro.repository;
/*
 * @Author Bhumika_Arora 
 */
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;

import com.nagarro.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long>{

}
