package com.linnyk.jpa.kk_java_tutorials.entities.multiple;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@ToString(exclude = "calls")
@Entity
@Table(name = "Phone")
public class Phone {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person person;

	@Column(name = "phone_number")
	private String number;

	@Enumerated(EnumType.STRING)
	@Column(name = "phone_type")
	private PhoneType type;

	@OneToMany(mappedBy = "phone", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Call> calls = new ArrayList<>( );

}