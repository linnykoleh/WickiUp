package com.learning.linnyk.ps.configuration.xml.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.learning.linnyk.ps.configuration.xml.Customer;

/**
 * @author LinnykOleh
 */
@Repository
public class HibernateCustomRepository implements CustomRepository{

	@Override
	public List<Customer> findAll() {
		final List<Customer> customers = new ArrayList<>();

		final Customer customer = new Customer();

		customer.setFirstName("Bryan");
		customer.setLastName("Hansen");

		customers.add(customer);

		return customers;
	}
}
