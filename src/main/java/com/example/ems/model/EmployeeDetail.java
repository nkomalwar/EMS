package com.example.ems.model;

import java.util.Set;

public class EmployeeDetail {

	private Employee employee;
	private Set<Address> address;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
}
