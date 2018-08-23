package com.linnyk.jpa.certification.entities.map;

import java.util.Date;
import java.util.HashMap;
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
@Table(name = "EMPLOYEE_CTM")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private Integer id;

	@ElementCollection
	@CollectionTable(name = "EMP_PROJECTS", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
	@MapKeyJoinColumn(name = "PROJECT_ID")
	@Column(name = "STARTDATE")
	private Map<Project, Date> currentProject = new HashMap<>();

}
