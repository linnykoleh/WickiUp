package com.linnyk.jpa.certification.entities.optimistic;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	private Long id;

	private String name;

}
