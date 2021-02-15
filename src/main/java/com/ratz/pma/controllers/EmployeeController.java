package com.ratz.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ratz.pma.dao.EmployeeRepository;
import com.ratz.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/new")
	public String employeeCreateForm( Model model) {
		
		Employee anEmployee = new Employee();
		
		model.addAttribute("employee" ,anEmployee);
		
		return "new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		
		empRepo.save(employee);
		
		return"redirect:/employees/new";
	}

}
