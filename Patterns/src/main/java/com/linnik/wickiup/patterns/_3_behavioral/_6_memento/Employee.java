package com.linnik.wickiup.patterns._3_behavioral._6_memento;

/**
 * Originator
 *
 * @author LinnykOleh
 */
public class Employee {

	private String name;
	private String address;
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public EmployeeMemento save(){
		return new EmployeeMemento(this.name, this.phone);
	}

	public void revert(EmployeeMemento employeeMemento){
		this.name = employeeMemento.getName();
		this.phone = employeeMemento.getPhone();
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}