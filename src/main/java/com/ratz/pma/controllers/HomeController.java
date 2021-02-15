package com.ratz.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ratz.pma.dao.EmployeeRepository;
import com.ratz.pma.dao.ProjectRepository;
import com.ratz.pma.entities.Employee;
import com.ratz.pma.entities.Project;

@Controller
public class HomeController {

	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		List<Project> projects = proRepo.findAll();
		
		List<Employee> employees = empRepo.findAll();
		
		model.addAttribute("projectsList", projects);
		model.addAttribute("employeeList", employees);
		
		return "home";
	}
	
	
}
