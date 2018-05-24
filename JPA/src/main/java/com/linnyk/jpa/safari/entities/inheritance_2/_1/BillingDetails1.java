package com.linnyk.jpa.safari.entities.inheritance_2._1;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetails1 {

	private String owner;

	public BillingDetails1() {
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "BillingDetails1{" +
				"owner='" + owner + '\'' +
				'}';
	}
}