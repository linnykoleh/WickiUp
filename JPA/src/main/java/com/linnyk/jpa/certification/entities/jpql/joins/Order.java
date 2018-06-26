package com.linnyk.jpa.certification.entities.jpql.joins;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "customer")
@Entity
@Table(name = "ORDER_J")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Integer id;

	@Column(name = "ORDER_DATE")
	private String orderDate;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

}
