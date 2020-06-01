package com.hanu.se2.api.service;

import java.util.List;

import com.hanu.se2.api.model.Employee;
import com.hanu.se2.base.Repository;
import com.hanu.se2.base.RestService;
import com.hanu.se2.repository.EmployeeRepository;

public class EmployeeService implements RestService<Employee, Integer> {
	private Repository<Employee, Integer> repository;
	
	public EmployeeService() {
		repository = new EmployeeRepository();
	}

	@Override
	public List<Employee> getAll() {
		return repository.findAll();
	}

	@Override
	public Employee getById(Integer id) {
		return repository.findById(id);
	}
}
