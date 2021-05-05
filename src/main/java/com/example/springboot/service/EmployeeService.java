package com.example.springboot.service;

import java.util.List;

import com.example.springboot.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	void saveEmployees(Employee employee);
	Employee getEmployeeByID(long id);
	void deleteEmployeeByID(long id);
}
