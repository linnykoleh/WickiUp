package com.linnyk.jpa.jee7.entities.order_column;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "NEWS_OC")
public class News {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String content;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderColumn(name = "posted_index")
	private List<Comment> comments;

	public News() {
	}

	public News(String content, List<Comment> comments) {
		this.content = content;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "News{" +
				"id=" + id +
				", content='" + content + '\'' +
				'}';
	}
}