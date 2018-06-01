package com.linnyk.jpa.jee7.entities.one_to_many_u.join_column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_LINE_C")
public class OrderLineC {

	@Id
	@GeneratedValue
	private Long id;
	private String item;
	private Double unitPrice;
	private Integer quantity;

	public OrderLineC() {
	}

	public OrderLineC(String item, Double unitPrice, Integer quantity) {
		this.item = item;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}