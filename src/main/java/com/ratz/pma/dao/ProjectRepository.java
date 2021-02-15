package com.ratz.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ratz.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	//we are overrinding to findAll return a list
	@Override
	public List<Project> findAll();
}
