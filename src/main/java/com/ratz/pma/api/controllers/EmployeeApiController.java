package com.ratz.pma.api.controllers;

import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ratz.pma.dao.EmployeeRepository;
import com.ratz.pma.entities.Employee;
import com.ratz.pma.services.EmployeeService;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

	@Autowired
	EmployeeService empService;

	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping()
	public Iterable<Employee> getEmployees() {
		return empService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") Long id) {
		return empService.getEmployeeById(id);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@RequestBody @Valid Employee employee) {
		return empService.save(employee);
	}

	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee update(@RequestBody Employee employee) {
		return empService.save(employee);
	}

	@PatchMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee partialEmployeeUpdate(@PathVariable long id, @RequestBody Employee patchEmployee) {
		Employee emp = empService.getEmployeeById(id).get();

		if (patchEmployee.getEmail() != null) {
			emp.setEmail(patchEmployee.getEmail());
		}

		if (patchEmployee.getFirstName() != null) {
			emp.setEmail(patchEmployee.getFirstName());
		}

		if (patchEmployee.getLastName() != null) {
			emp.setEmail(patchEmployee.getLastName());
		}

		return empService.save(patchEmployee);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable Long id) {
		try {
			empService.deleteEmployee(id);
		} catch (EmptyResultDataAccessException e) {

		}
	}
	
	@GetMapping(params = {"page", "size"})
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> findPaginatedEmployees(@RequestParam("page") int page,@RequestParam("size") int size) {
		Pageable pageAndSize = PageRequest.of(page, size);
		
		return empRepo.findAll(pageAndSize);
	}
	
}
