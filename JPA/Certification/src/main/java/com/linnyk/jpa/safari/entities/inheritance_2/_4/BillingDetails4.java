package com.linnyk.jpa.safari.entities.inheritance_2._4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "BILLING_DETAILS_4")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails4 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String owner;

	public int getId() {
		return id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "BillingDetails4{" +
				"id=" + id +
				", owner='" + owner + '\'' +
				'}';
	}
}