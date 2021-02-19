package com.ratz.pma.api.controllers;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratz.pma.dao.EmployeeRepository;
import com.ratz.pma.entities.Employee;
import com.ratz.pma.services.EmployeeService;




@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

	@Autowired
	EmployeeService empService;
	
	@Transactional
	@GetMapping()
	public List<Employee> getEmployees() {
		System.out.print( "HERE WHAT I SEND" + empService.getAll());
		return empService.getAll();
		
		}

}
