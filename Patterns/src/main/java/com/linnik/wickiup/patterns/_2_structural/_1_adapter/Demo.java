package com.linnik.wickiup.patterns._2_structural._1_adapter;

import java.util.List;

/**
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) {
		final EmployeeClient employeeClient = new EmployeeClient();

		final List<Employee> employeeList = employeeClient.getEmployeeList();

		System.out.println(employeeList);
	}
}
