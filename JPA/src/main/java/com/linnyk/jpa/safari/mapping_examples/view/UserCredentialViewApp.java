package com.linnyk.jpa.safari.mapping_examples.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Test;

import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class UserCredentialViewApp {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Query query = entityManager.createQuery("from UserCredentialView");
		final List resultList = query.getResultList();
		System.out.println(resultList);

//		System.out.println(userCredentialView);

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
