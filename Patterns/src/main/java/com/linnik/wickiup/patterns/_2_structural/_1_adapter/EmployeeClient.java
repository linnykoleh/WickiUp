package com.linnik.wickiup.patterns._2_structural._1_adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LinnykOleh
 */
public class EmployeeClient {

	public List<Employee> getEmployeeList(){

		final List<Employee> employees = new ArrayList<>();
		final Employee employee = new EmployeeDB("1234", "John", "Wick", "johg@wick.com");
		employees.add(employee);

		final EmployeeLdap employeeLdap = new EmployeeLdap("chewie", "Solo", "Han", "han@solo.com");
		employees.add(new EmployeeAdapterLdap(employeeLdap)); //adapter

		final EmployeeCVS employeeCVS = new EmployeeCVS(4321, "Solo", "Han", "han@solo.com");

		employees.add(new EmployeeAdapterCSV(employeeCVS)); //adapter
		return employees;
	}
}
