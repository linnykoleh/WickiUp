package com.linnyk.jpa.jee7.entities.one_to_many_u.join_column;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ORDER_C")
public class OrderC {

	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_ORDER")
	private List<OrderLineC> orderLineCS;

	public OrderC() {
	}

	public OrderC(Date creationDate, List<OrderLineC> orderLineCS) {
		this.creationDate = creationDate;
		this.orderLineCS = orderLineCS;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<OrderLineC> getOrderLineCS() {
		return orderLineCS;
	}

	public void setOrderLineCS(List<OrderLineC> orderLineTS) {
		this.orderLineCS = orderLineTS;
	}
}
