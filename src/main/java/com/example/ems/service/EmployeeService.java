package com.example.ems.service;

import java.util.List;

import com.example.ems.model.Employee;

public interface EmployeeService {

	long save(Employee employee);
	Employee get(long id);
	List<Employee> list();
	Employee delete(long id);
}
