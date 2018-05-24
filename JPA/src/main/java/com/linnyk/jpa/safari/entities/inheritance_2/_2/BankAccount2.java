package com.linnyk.jpa.safari.entities.inheritance_2._2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.linnyk.jpa.safari.entities.inheritance_2._1.BillingDetails1;

@Entity
@Table(name = "BANK_ACCOUNT_2")
public class BankAccount2 extends BillingDetails2 {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private int account;

	@Column(name = "bank_name")
	private String bankName;

	private String swift;

	public BankAccount2() {
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	@Override
	public String toString() {
		return "BankAccount1{" +
				"account=" + account +
				", bankName='" + bankName + '\'' +
				", swift='" + swift + '\'' +
				'}';
	}
}