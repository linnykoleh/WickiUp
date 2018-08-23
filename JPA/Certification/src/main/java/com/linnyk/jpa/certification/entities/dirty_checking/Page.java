package com.linnyk.jpa.certification.entities.dirty_checking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Immutable //need to prevent dirty checking
@Table(name = "PAGE")
public class Page {

	@Id
	@GeneratedValue
	@Column(name = "PAGE_ID")
	private long idPage;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CONTENT")
	private String content;

	public Page(String name, String content) {
		this.name = name;
		this.content = content;
	}

	public Page() {
	}
}
