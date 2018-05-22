package com.linnyk.jpa.safari.entities.inheritance.single_table;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "INVESTMENT_TYPE")
@Table(name = "INVESTMENT")
public abstract class InvestmentST {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
	@TableGenerator(name = "key_generator", table = "ifinances_keys", pkColumnName = "pk_name", valueColumnName = "pk_value")
	@Column(name = "INVESTMENT_ID")
	private Long investmentId;

	@JoinColumn(name = "PORTFOLIO_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private PortfolioST portfolio;

	@Column(name = "NAME")
	protected String name;

	@Column(name = "ISSUER")
	protected String issuer;

	@Column(name = "PURCHASE_DATE")
	protected Date purchaseDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Long getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(Long investmentId) {
		this.investmentId = investmentId;
	}

	public PortfolioST getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(PortfolioST portfolio) {
		this.portfolio = portfolio;
	}
}
