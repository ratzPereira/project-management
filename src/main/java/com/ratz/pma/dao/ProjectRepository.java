package com.ratz.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ratz.pma.dto.ProjectsStage;
import com.ratz.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	//we are overrinding to findAll return a list
	@Override
	public List<Project> findAll();
	
	
	@Query(nativeQuery=true,value="SELECT stage as label, Count(*) as value "
			+ "FROM project "
			+ "GROUP BY stage")
	public List<ProjectsStage> projectStatus();
}
