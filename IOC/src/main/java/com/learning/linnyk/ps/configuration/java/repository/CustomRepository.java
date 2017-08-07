package com.learning.linnyk.ps.configuration.java.repository;

import java.util.List;

import com.learning.linnyk.ps.configuration.java.Customer;

/**
 * @author LinnykOleh
 */
public interface CustomRepository {

	List<Customer> findAll();
}
