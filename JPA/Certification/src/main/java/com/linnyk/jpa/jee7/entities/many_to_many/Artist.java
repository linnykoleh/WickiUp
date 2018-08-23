package com.linnyk.jpa.jee7.entities.many_to_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "jnd_art_cd",
			joinColumns = @JoinColumn(name = "artist_fk"),
			inverseJoinColumns = @JoinColumn(name = "cd_fk"))
	private List<CD> appearsOnCDs;

	public Artist() {
	}

	public Artist(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<CD> getAppearsOnCDs() {
		return appearsOnCDs;
	}

	public void setAppearsOnCDs(List<CD> appearsOnCDs) {
		this.appearsOnCDs = appearsOnCDs;
	}
}