package com.linnyk.jpa.jee7.entities.listeners;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@EntityListeners(value = Listener.class)
@Entity
public class EntityListener {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EntityListener{" +
				"id=" + id +
				'}';
	}
}
