package com.linnyk.jpa.safari.mapping_examples.compound;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.safari.entities.compound.Currency;
import com.linnyk.jpa.safari.entities.compound.CurrencyId;
import com.linnyk.jpa.safari.entities.compound.Market;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import com.linnyk.jpa.safari.util.EntitiesUtil;

public class CurrencyApp {

	@Test
	public void testCompositeKey(){
		/**--------------------------------------------------------------*/

		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Currency currency = EntitiesUtil.getCurrency("Dollar");
		entityManager.persist(currency);

		transaction.commit();
		// insert into Currency (SYMBOL, COUNTRY_NAME, NAME) values (?, ?, ?)

		/**--------------------------------------------------------------*/

		final EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction2 = entityManager2.getTransaction();
		transaction2.begin();

		final Currency currency1 = entityManager2.find(Currency.class, new CurrencyId("Dollar", "United States"));
		// select currency0_.COUNTRY_NAME as COUNTRY_1_6_0_, currency0_.NAME as NAME2_6_0_, currency0_.SYMBOL as SYMBOL3_6_0_
		// from Currency currency0_ where currency0_.COUNTRY_NAME=? and currency0_.NAME=?

		System.out.println(currency1.getName()); //Dollar

		transaction2.commit();

		/**--------------------------------------------------------------*/

		entityManager.close();
		entityManager2.close();
		entityManagerFactory.close();
	}

	@Test
	public void testCompoundColumn(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Currency currency = EntitiesUtil.getCurrency("Dollar");

		final Market market = new Market();
		market.setMarketName("London Stock Exchange");
		market.setCurrency(currency);

		entityManager.persist(market);
		// insert into Currency (SYMBOL, COUNTRY_NAME, NAME) values (?, ?, ?)
		// insert into MARKET (MARKET_ID, COUNTRY_NAME, CURRENCY_NAME, MARKET_NAME) values (null, ?, ?, ?)

		transaction.commit();

		final Market dbMarket = entityManager.find(Market.class, market.getMarketId());
		System.out.println(dbMarket.getMarketName()); //London Stock Exchange

		entityManager.close();
		entityManagerFactory.close();
	}

}
