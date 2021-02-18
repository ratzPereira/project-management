package com.ratz.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.ratz.pma.services.EmployeeService;
import com.ratz.pma.services.ProjectService;

@Controller
public class HomeController {

	 @Value("${version}")
	private String version;
	
	@Autowired
	ProjectService proService;

	@Autowired
	EmployeeService empService;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		
		model.addAttribute("versionNumber", version);
		
		Map<String, Object> map = new HashMap<>();
		
		List<Project> projects = proService.getAll();
		model.addAttribute("projectsList", projects);
		
		List<ProjectsStage> projectsStage = proService.getProjectStatus();
		
		//Lets convert project data object into a json to use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectsStage);
		
		model.addAttribute("projectStatusCnt", jsonString);

		
		List<EmployeeProject> employeesProjectCount = empService.employeeProject();
		model.addAttribute("employeeListProjectCount", employeesProjectCount);

		return "main/home";
	}

}
