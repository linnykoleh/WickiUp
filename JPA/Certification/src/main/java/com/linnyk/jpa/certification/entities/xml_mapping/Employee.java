package com.linnyk.jpa.certification.entities.xml_mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee {

	@Id
	private int id;

	@Column(name="EMP_NAME")
	private String name;

	@Column(name="SAL")
	private long salary;

	public Employee(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}
}
