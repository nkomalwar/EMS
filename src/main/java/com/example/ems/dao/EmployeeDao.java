package com.example.ems.dao;

import java.util.List;

import com.example.ems.model.Employee;

public interface EmployeeDao {
	long save(Employee employee);
	Employee get(long id);
	List<Employee> list();
	void update(long id, Employee employee);
	Employee delete(long id);

}