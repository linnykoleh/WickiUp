package com.linnyk.jpa.safari.entities.inheritance_2._3;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREDIT_CARD_3")
@DiscriminatorValue("CC")
public class CreditCard3 extends BillingDetails3 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "card_number")
	private int cardNumber;

	@Column(name = "exp_month")
	private String expMonth;

	@Column(name = "exp_year")
	private String expYear;

	public CreditCard3() {
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
		return "CreditCard3{" +
				"cardNumber=" + cardNumber +
				", expMonth='" + expMonth + '\'' +
				", expYear='" + expYear + '\'' +
				'}';
	}
}