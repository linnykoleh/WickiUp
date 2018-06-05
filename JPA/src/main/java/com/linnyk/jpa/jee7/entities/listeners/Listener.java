package com.linnyk.jpa.jee7.entities.listeners;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class Listener {

	public Listener() {
	}

	@PostLoad
	@PostPersist
	@PostUpdate
	public void validate(EntityListener entityListener) {
		System.out.println(entityListener);
		// EntityListener{id=1}
	}
}
