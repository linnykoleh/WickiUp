package com.linnyk.jpa.safari.entities.inheritance;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock extends Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STOCK_ID")
	private Long stockId;

	@Column(name = "SHARE_PRICE")
	private BigDecimal sharePrice;

	@Column(name = "QUANTITY")
	private BigDecimal quantity;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public BigDecimal getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(BigDecimal sharePrice) {
		this.sharePrice = sharePrice;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
