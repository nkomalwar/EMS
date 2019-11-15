package com.example.ems.dao;

import java.util.List;

import com.example.ems.model.Address;

public interface AddressDao {
	long save(Address address);
	List<Address> getAddressByEmpId(long id);
	List<Address> deleteAddressbyEmpId(long id);
}
