package com.example.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ems.dao.EmployeeDao;
import com.example.ems.model.Employee;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	@Override
	public long save(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public Employee get(long id) {
		return employeeDao.get(id);
	}

	@Override
	public List<Employee> list() {
		return employeeDao.list();
	}

	@Transactional
	@Override
	public Employee delete(long id) {
		return employeeDao.delete(id);
	}

}
