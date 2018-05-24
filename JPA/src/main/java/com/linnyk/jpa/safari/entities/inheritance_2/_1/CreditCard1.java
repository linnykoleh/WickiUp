package com.linnyk.jpa.safari.entities.inheritance_2._1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREDIT_CARD_1")
public class CreditCard1 extends BillingDetails1 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "card_number")
	private int cardNumber;

	@Column(name = "exp_month")
	private String expMonth;

	@Column(name = "exp_year")
	private String expYear;

	public CreditCard1() {
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	@Override
	public String toString() {
		return "CreditCard1{" +
				"cardNumber=" + cardNumber +
				", expMonth='" + expMonth + '\'' +
				", expYear='" + expYear + '\'' +
				'}';
	}
}