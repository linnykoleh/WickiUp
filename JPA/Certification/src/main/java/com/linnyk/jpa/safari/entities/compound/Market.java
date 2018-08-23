package com.linnyk.jpa.safari.entities.compound;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MARKET")
public class Market {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MARKET_ID")
	private Long marketId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({
			@JoinColumn(name = "CURRENCY_NAME", referencedColumnName = "NAME"),
			@JoinColumn(name = "COUNTRY_NAME", referencedColumnName = "COUNTRY_NAME")
	})
	private Currency currency;

	@Column(name = "MARKET_NAME")
	private String marketName;

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public final Currency getCurrency() {
		return currency;
	}

	public final void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
