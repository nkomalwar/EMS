package com.example.ems.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ems.model.Address;

public class AddressDaoImpl implements AddressDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Address address) {
		sessionFactory.getCurrentSession().save(address);
		return address.getId();
	}

	@Override
	public List<Address> getAddressByEmpId(long id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Address> cq = cb.createQuery(Address.class);
		Root<Address> root = cq.from(Address.class);
		cq.select(root);
		Query<Address> query = session.createQuery(cq);

		List<Address> allAddresses = query.getResultList();
		List<Address> addresses = new ArrayList<Address>();
		for (Address addr : allAddresses) {
			if (addr.getEmployee().getEmpId() == id) {
				addresses.add(addr);
			}
		}

		return addresses;
	}

	@Override
	public List<Address> deleteAddressbyEmpId(long id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Address> cq = cb.createQuery(Address.class);
		Root<Address> root = cq.from(Address.class);
		cq.select(root);
		Query<Address> query = session.createQuery(cq);

		List<Address> allAddresses = query.getResultList();
		List<Address> addresses = new ArrayList<Address>();
		for (Address addr : allAddresses) {
			if (addr.getEmployee().getEmpId() == id) {
				addresses.add(addr);
			}
		}

		for (Address addr : addresses) {
			Address address = session.byId(Address.class).load(addr.getId());
			session.delete(address);
		}
		return addresses;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
