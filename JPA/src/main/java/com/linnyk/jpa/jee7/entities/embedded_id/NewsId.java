package com.linnyk.jpa.jee7.entities.embedded_id;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class NewsId implements Serializable {

	private String title;
	private String language;

	public NewsId() {
	}

	public NewsId(String title, String language) {
		this.title = title;
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}

