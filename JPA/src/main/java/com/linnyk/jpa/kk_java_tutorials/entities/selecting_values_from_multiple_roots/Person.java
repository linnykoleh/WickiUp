package com.linnyk.jpa.kk_java_tutorials.entities.selecting_values_from_multiple_roots;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

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
@Table(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "nickName")
	private String nickName;

	@Column(name = "address")
	private String address;

	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "createdOn")
	private Date createdOn;

	@Version
	@Column(name = "version")
	private int version;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Phone> phones = new ArrayList<>();

}