package com.learning.linnyk.ps.java.service;

import java.util.List;

import com.learning.linnyk.ps.java.Customer;
import com.learning.linnyk.ps.java.repository.CustomRepository;

/**
 * @author LinnykOleh
 */
public interface CustomerService {

	List<Customer> findAll();

	CustomRepository getCustomRepository();
}
