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
		final EntityManager em = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		final OptimisticEntity optimisticEntity = new OptimisticEntity();
		optimisticEntity.setName("optimisticEntity");

		em.persist(optimisticEntity);

		transaction.commit();
		em.close();

		System.out.println("-----###################-----");

		final EntityManager em1 = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction1 = em1.getTransaction();
		transaction1.begin();

		final OptimisticEntity optimisticEntity1 = em1.find(OptimisticEntity.class, optimisticEntity.getId());
		optimisticEntity1.setName("NewOptimisticEntity 1");

		new Thread(() -> {
			//Update version in order to get OptimisticLockException
			final EntityManager em2 = entityManagerFactory.createEntityManager();
			final EntityTransaction transaction2 = em2.getTransaction();
			transaction2.begin();

			final OptimisticEntity optimisticEntity2 = em2.find(OptimisticEntity.class, optimisticEntity.getId());
			optimisticEntity2.setName("NewOptimisticEntity 2");

			transaction2.commit();
			em2.close();

		}).start();

		Thread.sleep(10000);

		transaction1.commit();
		em1.close();
		// javax.persistence.OptimisticLockException: Batch update returned unexpected row count from update [0]; actual row count: 0; expected: 1

		entityManagerFactory.close();
	}
}
