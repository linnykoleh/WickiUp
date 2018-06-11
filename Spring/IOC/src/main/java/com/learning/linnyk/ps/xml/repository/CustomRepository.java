package com.learning.linnyk.ps.xml.repository;

import java.util.List;

import com.learning.linnyk.ps.xml.Customer;

/**
 * @author LinnykOleh
 */
public interface CustomRepository {

	List<Customer> findAll();
}
