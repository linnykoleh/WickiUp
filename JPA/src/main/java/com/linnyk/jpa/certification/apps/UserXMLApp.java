package com.linnyk.jpa.certification.apps;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.certification.entities.UserXML;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class UserXMLApp {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final UserXML userXML = new UserXML();

		entityManager.persist(userXML);
		// insert into UserXML_XML (id, USER_NAME) values (null, ?)

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
