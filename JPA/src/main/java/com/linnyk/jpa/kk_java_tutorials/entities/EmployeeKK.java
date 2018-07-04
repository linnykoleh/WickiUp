package com.linnyk.jpa.kk_java_tutorials.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="employee_table")
public class EmployeeKK {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;

	@Column(name="employee_name",length = 100, nullable = false)
	private String employeeName;

	@Column(name="email", unique=true)
	private String email;

	@Column(name="date_of_joing")
	private Date doj;

	@Column(name="salary")
	private Double salary;

}