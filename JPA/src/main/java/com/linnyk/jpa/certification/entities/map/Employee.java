package com.linnyk.jpa.certification.entities.map;

import java.util.Date;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private Integer id;

	@ElementCollection
	@CollectionTable(name = "EMP_PROJECTS", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
	@Column(name = "STARTDATE")
	@MapKeyJoinColumn(name = "PROJECT_ID")
	private Map<Project, Date> currentProject;

}
