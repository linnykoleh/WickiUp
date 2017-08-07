package com.learning.linnyk.ps.configuration.xml.repository;

import java.util.List;

import com.learning.linnyk.ps.configuration.xml.Customer;

/**
 * @author LinnykOleh
 */
public interface CustomRepository {

	List<Customer> findAll();
}
