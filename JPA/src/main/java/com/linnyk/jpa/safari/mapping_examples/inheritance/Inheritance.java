package com.linnyk.jpa.safari.mapping_examples.inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.safari.entities.inheritance.Bond;
import com.linnyk.jpa.safari.entities.inheritance.Stock;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import com.linnyk.jpa.safari.util.EntitiesUtil;

public class Inheritance {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Stock stock = EntitiesUtil.getStock("Stock");
		entityManager.persist(stock);

		final Bond bond = EntitiesUtil.getBond("Bond");
		entityManager.persist(bond);

		transaction.commit();
		//insert into STOCK (STOCK_ID, ISSUER, NAME, PURCHASE_DATE, QUANTITY, SHARE_PRICE) values (null, ?, ?, ?, ?, ?)
		//insert into BOND (BOND_ID, ISSUER, NAME, PURCHASE_DATE, INTEREST_RATE, MATURITY_DATE, VALUE) values (null, ?, ?, ?, ?, ?, ?)

		entityManager.close();
		entityManagerFactory.close();
	}
}
