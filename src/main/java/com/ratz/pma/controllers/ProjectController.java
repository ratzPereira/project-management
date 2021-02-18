package com.ratz.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ratz.pma.dao.EmployeeRepository;
import com.ratz.pma.dao.ProjectRepository;
import com.ratz.pma.entities.Employee;
import com.ratz.pma.entities.Project;
import com.ratz.pma.services.EmployeeService;
import com.ratz.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
		
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Project> projects =  proService.getAll();
		model.addAttribute("projects",projects);
		
		return "/projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		List<Employee> employees = empService.getAll();
		model.addAttribute("allEmployees", employees);
		model.addAttribute("project", aProject);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createPost(Project project,  Model model) {
	
		//saving project to db using repository
		proService.save(project);
		
		//use redirect to prevent duplicate entry 
		return "redirect:/projects";
	}
	
}
