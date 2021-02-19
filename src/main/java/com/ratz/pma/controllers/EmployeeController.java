package com.ratz.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ratz.pma.dao.EmployeeRepository;
import com.ratz.pma.entities.Employee;
import com.ratz.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayEmployees(Model model) {
		Iterable<Employee> employees =  empService.getAll();
		model.addAttribute("employees",employees);
		
		return "/employees/list-employees";
	}
	
	@GetMapping("/new")
	public String employeeCreateForm( Model model) {
		
		Employee anEmployee = new Employee();
		
		model.addAttribute("employee" ,anEmployee);
		
		return "/employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		
		empService.save(employee);
		
		return"redirect:/employees/new";
	}

}
