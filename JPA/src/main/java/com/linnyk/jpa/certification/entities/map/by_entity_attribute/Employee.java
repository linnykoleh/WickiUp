package com.linnyk.jpa.certification.entities.map.by_entity_attribute;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "EMPLOYEE_EA")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private Integer id;

	@Column(name = "EMPLOYEE_NAME")
	@NonNull
	private String name;

	@ManyToOne
	private Department department;

}
