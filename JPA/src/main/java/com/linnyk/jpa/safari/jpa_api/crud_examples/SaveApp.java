package com.linnyk.jpa.safari.jpa_api.crud_examples;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.safari.entities.embedded.Bank;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import com.linnyk.jpa.safari.util.EntitiesUtil;

public class SaveApp {

	@Test
	public void testSaving() {
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		final Bank bank = EntitiesUtil.getBank("My JPA Bank");
		entityManager.persist(bank);
		// insert into BANK (BANK_ID, ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, CREATED_BY, CREATED_DATE, IS_INTERNATIONAL, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
