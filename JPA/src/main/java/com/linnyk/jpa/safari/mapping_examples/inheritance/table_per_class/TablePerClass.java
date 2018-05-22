package com.linnyk.jpa.safari.mapping_examples.inheritance.table_per_class;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.safari.entities.inheritance.table_per_class.BondTPC;
import com.linnyk.jpa.safari.entities.inheritance.table_per_class.InvestmentTPC;
import com.linnyk.jpa.safari.entities.inheritance.table_per_class.Portfolio;
import com.linnyk.jpa.safari.entities.inheritance.table_per_class.StockTPC;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import com.linnyk.jpa.safari.util.EntitiesUtil;

public class TablePerClass {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Portfolio portfolio = new Portfolio();
		portfolio.setName("First Investment");

		final StockTPC stock = EntitiesUtil.getStockTPC("Stock");
		stock.setPortfolio(portfolio);

		final BondTPC bond = EntitiesUtil.getBondTPC("Bond");
		bond.setPortfolio(portfolio);

		portfolio.getInvestements().add(bond);
		portfolio.getInvestements().add(stock);

		entityManager.persist(stock);
		entityManager.persist(bond);

		transaction.commit();

		final Portfolio dbPortfolio = entityManager.find(Portfolio.class, portfolio.getPortfolioId());
		entityManager.refresh(dbPortfolio);

		for (InvestmentTPC investmentTPC: dbPortfolio.getInvestements()) {
			System.out.println(investmentTPC.getName());
		}

		// select tbl.pk_value from IFINANCES_KEYS tbl where tbl.pk_name=? for update
		// insert into IFINANCES_KEYS (pk_name, pk_value)  values (?,?)
		// update IFINANCES_KEYS set pk_value=?  where pk_value=? and pk_name=?
		// select tbl.pk_value from IFINANCES_KEYS tbl where tbl.pk_name=? for update
		// update IFINANCES_KEYS set pk_value=?  where pk_value=? and pk_name=?
		// insert into PORTFOLIO (PORTFOLIO_ID, NAME) values (null, ?)
		// insert into STOCK_TPC (ISSUER, NAME, PORTFOLIO_ID, PURCHASE_DATE, QUANTITY, SHARE_PRICE, INVESTMENT_ID) values (?, ?, ?, ?, ?, ?, ?)
		// insert into BOND_TPC (ISSUER, NAME, PORTFOLIO_ID, PURCHASE_DATE, INTEREST_RATE, MATURITY_DATE, VALUE, INVESTMENT_ID) values (?, ?, ?, ?, ?, ?, ?, ?)
		// select portfolio0_.PORTFOLIO_ID as PORTFOLI1_12_0_, portfolio0_.NAME as NAME2_12_0_ from PORTFOLIO portfolio0_ where portfolio0_.PORTFOLIO_ID=?
		// select investemen0_.PORTFOLIO_ID as PORTFOLI5_10_0_, investemen0_.INVESTMENT_ID as INVESTME1_10_0_, investemen0_.INVESTMENT_ID as INVESTME1_10_1_, investemen0_.ISSUER as ISSUER2_10_1_, investemen0_.NAME as NAME3_10_1_, investemen0_.PORTFOLIO_ID as PORTFOLI5_10_1_, investemen0_.PURCHASE_DATE as PURCHASE4_10_1_, investemen0_.QUANTITY as QUANTITY1_14_1_, investemen0_.SHARE_PRICE as SHARE_PR2_14_1_, investemen0_.INTEREST_RATE as INTEREST1_4_1_, investemen0_.MATURITY_DATE as MATURITY2_4_1_, investemen0_.VALUE as VALUE3_4_1_, investemen0_.clazz_ as clazz_1_ from ( select INVESTMENT_ID, ISSUER, NAME, PURCHASE_DATE, PORTFOLIO_ID, QUANTITY, SHARE_PRICE, null as INTEREST_RATE, null as MATURITY_DATE, null as VALUE, 1 as clazz_ from STOCK_TPC union all select INVESTMENT_ID, ISSUER, NAME, PURCHASE_DATE, PORTFOLIO_ID, null as QUANTITY, null as SHARE_PRICE, INTEREST_RATE, MATURITY_DATE, VALUE, 2 as clazz_ from BOND_TPC ) investemen0_ where investemen0_.PORTFOLIO_ID=?
		// Stock
		// Bond


		entityManager.close();
		entityManagerFactory.close();
	}
}
