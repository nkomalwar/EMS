package com.example.ems.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ems.dao.AddressDao;
import com.example.ems.dao.EmployeeDao;
import com.example.ems.model.Address;
import com.example.ems.model.Employee;
import com.example.ems.model.EmployeeDetail;

public class EmployeeDetailServiceImpl implements EmployeeDetailService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public long save(EmployeeDetail employee) {
		long employeeId = employeeDao.save(employee.getEmployee());
		for (Address addr : employee.getAddress()) {
			addressDao.save(addr);
		}
		
		return employeeId;
	}

	@Override
	public EmployeeDetail get(long id) {
		EmployeeDetail empDetail = new EmployeeDetail();
		empDetail.setEmployee(employeeDao.get(id));
		Set<Address> addr = new HashSet<Address>(addressDao.getAddressByEmpId(id));
		empDetail.setAddress(addr);
		
		return empDetail;
	}

	@Override
	public List<EmployeeDetail> list() {
		List<EmployeeDetail> empDetails = new ArrayList<EmployeeDetail>();
		List<Employee> empList = employeeDao.list();

		for (Employee emp : empList) {
			EmployeeDetail empDetail = new EmployeeDetail();
			empDetail.setEmployee(emp);
			empDetail.setAddress(new HashSet<Address>(addressDao.getAddressByEmpId(emp.getEmpId())));
			
			empDetails.add(empDetail);
		}
		return null;
	}

	@Override
	public EmployeeDetail delete(long id) {
		EmployeeDetail empDetail = new EmployeeDetail();
		empDetail.setAddress(new HashSet<Address>(addressDao.deleteAddressbyEmpId(id)));
		empDetail.setEmployee(employeeDao.delete(id));

		return empDetail;
	}

}
