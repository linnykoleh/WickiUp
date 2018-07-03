package com.linnyk.jpa.certification.entities.optimistic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OptimisticEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Version
	private int version;

}
