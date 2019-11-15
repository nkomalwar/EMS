package com.example.ems.service;

import java.util.List;

import com.example.ems.model.EmployeeDetail;

public interface EmployeeDetailService {

	long save(EmployeeDetail employee);
	EmployeeDetail get(long id);
	List<EmployeeDetail> list();
	EmployeeDetail delete(long id);
}
