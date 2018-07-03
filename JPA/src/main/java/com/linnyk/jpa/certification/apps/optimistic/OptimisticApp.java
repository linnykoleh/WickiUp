package com.linnyk.jpa.certification.apps.optimistic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.certification.entities.optimistic.OptimisticEntity;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class OptimisticApp {

	@Test
	public void test() throws InterruptedException {
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final OptimisticEntity optimisticEntity = new OptimisticEntity();
		optimisticEntity.setName("optimisticEntity");

		entityManager.persist(optimisticEntity);

		transaction.commit();
		entityManager.close();

		final EntityManager entityManager1 = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction1 = entityManager1.getTransaction();
		transaction1.begin();

		final OptimisticEntity optimisticEntity1 = entityManager1.find(OptimisticEntity.class, optimisticEntity.getId());
		optimisticEntity1.setName("NewOptimisticEntity");

		new Thread(() -> {
			//Update version in order to get OptimisticLockException
			final EntityManager entityManager2 = entityManagerFactory.createEntityManager();
			final EntityTransaction transaction2 = entityManager2.getTransaction();
			transaction2.begin();

			final OptimisticEntity optimisticEntity2 = entityManager2.find(OptimisticEntity.class, optimisticEntity.getId());
			optimisticEntity2.setVersion(2);

			transaction2.commit();
			entityManager2.close();

		}).start();

		Thread.sleep(10000);

		transaction1.commit();
		entityManager1.close();
		// javax.persistence.OptimisticLockException: Batch update returned unexpected row count from update [0]; actual row count: 0; expected: 1

		entityManagerFactory.close();
	}
}
