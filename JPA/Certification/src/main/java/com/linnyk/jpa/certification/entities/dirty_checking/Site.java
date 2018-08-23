package com.linnyk.jpa.certification.entities.dirty_checking;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Immutable
@Table(name = "SITE")
public class Site {

	@Id
	@GeneratedValue
	@Column(name = "SITE_ID")
	private long idSite;

	@Column(name = "NAME")
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SITE_JOIN_COLUMN")
	private Set<Page> pages;

	public Site(String name) {
		this.name = name;
	}

	public Site() {
	}
}
