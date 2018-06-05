package com.linnyk.jpa.jee7.entities.callbacks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Entity
public class CallBack {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	public CallBack() {
	}

	public CallBack(String name) {
		this.name = name;
	}

	@PrePersist
	public void prePersist(){
		System.out.println("@PrePersist");
	}

	@PostPersist
	public void postPersist(){
		System.out.println("@PostPersist");
	}

	@PreUpdate
	public void preUpdate(){
		System.out.println("@PreUpdate");
	}

	@PostUpdate
	public void postUpdate(){
		System.out.println("@PostUpdate");
	}

	@PreRemove
	public void preRemove(){
		System.out.println("@PreRemove");
	}

	@PostRemove
	public void postRemove(){
		System.out.println("@PostRemove");
	}

	@PostLoad
	public void postLoad(){
		System.out.println("@PostLoad");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
