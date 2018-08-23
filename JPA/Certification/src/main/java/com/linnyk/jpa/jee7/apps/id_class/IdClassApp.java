package com.linnyk.jpa.jee7.apps.id_class;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.id_class.News;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class IdClassApp {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final News news = new News("Title", "UA", "Content");

		entityManager.persist(news);

		/**

		 NEWS_ID_C Table

		 LANGUAGE  - Primary Key
		 TITLE - Primary Key
		 ------------------------------
		 |*LANGUAGE*|*TITLE*| CONTENT |
		 ------------------------------
		 | UA	    | Title	| Content |
		 ------------------------------

		 */

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
