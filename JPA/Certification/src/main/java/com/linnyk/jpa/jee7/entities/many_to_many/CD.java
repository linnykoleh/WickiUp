package com.linnyk.jpa.jee7.entities.many_to_many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CD {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private Float price;
	private String description;
	@ManyToMany(mappedBy = "appearsOnCDs")
	private List<Artist> createdByArtists;

	public CD() {
	}

	public CD(String title, Float price, String description, List<Artist> createdByArtists) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.createdByArtists = createdByArtists;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Artist> getCreatedByArtists() {
		return createdByArtists;
	}

	public void setCreatedByArtists(List<Artist> createdByArtists) {
		this.createdByArtists = createdByArtists;
	}
}