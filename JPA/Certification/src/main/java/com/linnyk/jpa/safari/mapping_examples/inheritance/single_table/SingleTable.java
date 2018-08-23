package com.linnyk.jpa.safari.mapping_examples.inheritance.single_table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.safari.entities.inheritance.single_table.BondST;
import com.linnyk.jpa.safari.entities.inheritance.single_table.PortfolioST;
import com.linnyk.jpa.safari.entities.inheritance.single_table.StockST;
import com.linnyk.jpa.safari.entities.inheritance.table_per_class.BondTPC;
import com.linnyk.jpa.safari.entities.inheritance.table_per_class.InvestmentTPC;
import com.linnyk.jpa.safari.entities.inheritance.table_per_class.Portfolio;
import com.linnyk.jpa.safari.entities.inheritance.table_per_class.StockTPC;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import com.linnyk.jpa.safari.util.EntitiesUtil;

public class SingleTable {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final PortfolioST portfolio = new PortfolioST();
		portfolio.setName("First Investment");

		final StockST stock = EntitiesUtil.getStockST("Stock");
		stock.setPortfolio(portfolio);

		final BondST bond = EntitiesUtil.getBondST("Bond");
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
		// insert into INVESTMENT (ISSUER, NAME, PORTFOLIO_ID, PURCHASE_DATE, QUANTITY, SHARE_PRICE, INVESTMENT_TYPE, INVESTMENT_ID) values (?, ?, ?, ?, ?, ?, 'StockST', ?)
		// insert into INVESTMENT (ISSUER, NAME, PORTFOLIO_ID, PURCHASE_DATE, INTEREST_RATE, MATURITY_DATE, VALUE, INVESTMENT_TYPE, INVESTMENT_ID) values (?, ?, ?, ?, ?, ?, ?, 'BondST', ?)
		// select portfolio0_.PORTFOLIO_ID as PORTFOLI1_13_0_, portfolio0_.NAME as NAME2_13_0_ from PORTFOLIO portfolio0_ where portfolio0_.PORTFOLIO_ID=?
		// select portfolio0_.PORTFOLIO_ID as PORTFOLI1_13_0_, portfolio0_.NAME as NAME2_13_0_ from PORTFOLIO portfolio0_ where portfolio0_.PORTFOLIO_ID=?
		// select investemen0_.PORTFOLIO_ID as PORTFOLI5_11_0_, investemen0_.INVESTMENT_ID as INVESTME1_11_0_, investemen0_.INVESTMENT_ID as INVESTME1_11_1_, investemen0_.ISSUER as ISSUER2_11_1_, investemen0_.NAME as NAME3_11_1_, investemen0_.PORTFOLIO_ID as PORTFOLI5_11_1_, investemen0_.PURCHASE_DATE as PURCHASE4_11_1_, investemen0_.QUANTITY as QUANTITY1_15_1_, investemen0_.SHARE_PRICE as SHARE_PR2_15_1_, investemen0_.INTEREST_RATE as INTEREST1_4_1_, investemen0_.MATURITY_DATE as MATURITY2_4_1_, investemen0_.VALUE as VALUE3_4_1_, investemen0_.clazz_ as clazz_1_ from ( select INVESTMENT_ID, ISSUER, NAME, PURCHASE_DATE, PORTFOLIO_ID, QUANTITY, SHARE_PRICE, null as INTEREST_RATE, null as MATURITY_DATE, null as VALUE, 1 as clazz_ from STOCK_TPC union all select INVESTMENT_ID, ISSUER, NAME, PURCHASE_DATE, PORTFOLIO_ID, null as QUANTITY, null as SHARE_PRICE, INTEREST_RATE, MATURITY_DATE, VALUE, 2 as clazz_ from BOND_TPC ) investemen0_ where investemen0_.PORTFOLIO_ID=?

		entityManager.close();
		entityManagerFactory.close();
	}
}
