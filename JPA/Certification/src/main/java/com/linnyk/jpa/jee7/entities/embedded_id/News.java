package com.linnyk.jpa.jee7.entities.embedded_id;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NEWS_EMB")
public class News {

	@EmbeddedId
	private NewsId id;

	private String content;

	public News() {
	}

	public News(NewsId id, String content) {
		this.id = id;
		this.content = content;
	}

	public NewsId getId() {
		return id;
	}

	public void setId(NewsId id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}