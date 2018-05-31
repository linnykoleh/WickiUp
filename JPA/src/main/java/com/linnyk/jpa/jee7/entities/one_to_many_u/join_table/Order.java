package com.linnyk.jpa.jee7.entities.one_to_many_u.join_table;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ORDER_T")
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ORDER_TO_ORDER_LINE",
			joinColumns = @JoinColumn(name = "order_fk"),
			inverseJoinColumns = @JoinColumn(name = "order_line_fk") )
	private List<OrderLine> orderLines;

	public Order() {
	}

	public Order(Date creationDate, List<OrderLine> orderLines) {
		this.creationDate = creationDate;
		this.orderLines = orderLines;
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

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
}
