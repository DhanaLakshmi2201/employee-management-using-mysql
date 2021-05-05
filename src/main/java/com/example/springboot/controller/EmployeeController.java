package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot.model.Employee;
import com.example.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private  EmployeeService employeeService; 
	
	//display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("ListEmployees", employeeService.getAllEmployees());
		return "index" ;
		
	}
	@GetMapping("/showNewEmployeeform")
	public String showNewEmployeeform(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new _employee";
		
	}
	@PostMapping("/SaveEmployee")
	public String SaveEmployee(@ModelAttribute("employee")Employee employee) {
		employeeService.saveEmployees(employee);
		return "redirect:/";
		}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id")long id,Model model) {
		
		Employee employee =employeeService.getEmployeeByID(id);
		
		model.addAttribute("employee", employee);
		return "update_employee" ;
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id")long id) {
		
		this.employeeService.deleteEmployeeByID(id);
		return "redirect:/";
		
		
	}
}
