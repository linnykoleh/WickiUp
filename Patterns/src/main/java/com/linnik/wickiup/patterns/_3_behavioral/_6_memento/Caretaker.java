package com.linnik.wickiup.patterns._3_behavioral._6_memento;

import java.util.Stack;

/**
 * Caretaker
 *
 * @author LinnykOleh
 */
public class Caretaker {

	private Stack<EmployeeMemento> employeeHistory = new Stack<>();

	public void save(Employee employee){
		employeeHistory.push(employee.save());
	}

	public void revert(Employee employee){
		employee.revert(employeeHistory.pop());
	}
}
