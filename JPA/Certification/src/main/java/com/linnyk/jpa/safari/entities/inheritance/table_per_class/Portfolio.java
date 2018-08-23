package com.linnyk.jpa.safari.entities.inheritance.table_per_class;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PORTFOLIO")
public class Portfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PORTFOLIO_ID")
	private Long portfolioId;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "portfolio")
	private List<InvestmentTPC> investements = new ArrayList<>();

	public Long getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<InvestmentTPC> getInvestements() {
		return investements;
	}

	public void setInvestements(List<InvestmentTPC> investements) {
		this.investements = investements;
	}

}
