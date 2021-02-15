package com.ratz.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ratz.pma.dao.ProjectRepository;
import com.ratz.pma.entities.Employee;
import com.ratz.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository proRepo;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Project> projects =  proRepo.findAll();
		model.addAttribute("projects",projects);
		
		return "/projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		
		model.addAttribute("project", aProject);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createPost(Project project, Model model) {
	
		//saving project to db using repository
		proRepo.save(project);
		
		//use redirect to prevent duplicate entry 
		return "redirect:/projects/new";
	}
	
}
