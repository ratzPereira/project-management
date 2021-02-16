package com.ratz.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ratz.pma.dao.EmployeeRepository;
import com.ratz.pma.dao.ProjectRepository;
import com.ratz.pma.dto.EmployeeProject;
import com.ratz.pma.dto.ProjectsStage;
import com.ratz.pma.entities.Employee;
import com.ratz.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		Map<String, Object> map = new HashMap<>();
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		List<ProjectsStage> projectsStage = proRepo.projectStatus();
		
		//Lets convert project data object into a json to use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectsStage);
		
		model.addAttribute("projectStatusCnt", jsonString);

		
		List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
		model.addAttribute("employeeListProjectCount", employeesProjectCount);

		return "main/home";
	}

}
