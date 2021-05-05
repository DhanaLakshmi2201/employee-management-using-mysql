package com.example.springboot.repoaitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Long>{

}
