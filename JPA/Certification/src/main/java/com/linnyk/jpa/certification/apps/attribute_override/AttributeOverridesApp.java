package com.linnyk.jpa.certification.apps.attribute_override;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.certification.entities.attribute_override.Customer;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class AttributeOverridesApp {

	@Test
	public void testAttributeOverrides(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Customer customer = new Customer();

		entityManager.persist(customer);

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}


}
