package com.ratz.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.ratz.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
