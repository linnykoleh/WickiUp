package com.learning.linnyk.ps.java.repository;

import java.util.List;

import com.learning.linnyk.ps.java.Customer;

/**
 * @author LinnykOleh
 */
public interface CustomRepository {

	List<Customer> findAll();
}
