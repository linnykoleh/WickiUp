package com.linnyk.jpa.kk_java_tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeDTO {

	private String employeeName;

	private String email;

	private Double salary;

}
