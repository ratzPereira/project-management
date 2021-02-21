package com.ratz.pma.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratz.pma.dao.EmployeeRepository;
import com.ratz.pma.dto.EmployeeProject;
import com.ratz.pma.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	public Employee save (Employee employee) {
		return empRepo.save(employee);
	}
	
	@Transactional
	public List<Employee> getAll() {
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProject() {
		return empRepo.employeeProjects();
	}
	
	public Optional<Employee> getEmployeeById(long id) {
		return empRepo.findById(id);
	}
	
	public void deleteEmployee(long id) {
		empRepo.deleteById(id);
	}
}
