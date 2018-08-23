package com.linnyk.jpa.safari.entities.inheritance.single_table;

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
public class PortfolioST {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PORTFOLIO_ID")
	private Long portfolioId;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "portfolio")
	private List<InvestmentST> investements = new ArrayList<>();

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

	public List<InvestmentST> getInvestements() {
		return investements;
	}

	public void setInvestements(List<InvestmentST> investements) {
		this.investements = investements;
	}

}
