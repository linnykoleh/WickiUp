package com.linnyk.jpa.jee7.apps.listeners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.listeners.EntityListener;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class ListenerApp {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final EntityListener entityListener = new EntityListener();
		entityManager.persist(entityListener);

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
