package com.linnyk.jpa.jee7.apps.embedded_id;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.embedded_id.News;
import com.linnyk.jpa.jee7.entities.embedded_id.NewsId;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class EmbeddedIdApp {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final News news = new News(new NewsId("title", "en"), "Content");

		/**

		 NEWS_EMB Table

		 LANGUAGE  - Primary Key
		 TITLE - Primary Key
		 ------------------------------
		 |*LANGUAGE*|*TITLE*| CONTENT |
		 ------------------------------
		 | en	    | title	| Content |
		 ------------------------------

		 */

		entityManager.persist(news);

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
