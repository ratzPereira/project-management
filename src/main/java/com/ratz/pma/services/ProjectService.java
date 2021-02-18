package com.ratz.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratz.pma.dao.ProjectRepository;
import com.ratz.pma.dto.ProjectsStage;
import com.ratz.pma.entities.Project;

@Service
public class ProjectService {

	
	@Autowired
	ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll(){
		return proRepo.findAll();
		
	}
	
	public List<ProjectsStage> getProjectStatus() {
		return proRepo.projectStatus();
	}
	
}
