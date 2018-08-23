package com.linnyk.jpa.jee7.apps.attribute_overrides;

import com.linnyk.jpa.jee7.entities.attribute_overrides.Book;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class AttributesOverridesApp {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Book book = new Book("Title", 123.2F, "Description", "isbn", "Publisher", 324, true);

		entityManager.persist(book);

		// insert into Book (book_description, price, book_title, illustrations, isbn, nbOfPage, publisher, book_id)
		// values (?, ?, ?, ?, ?, ?, ?, ?)

		/**
		 *
		 BOOK
         ---------------------------------------------------------------------------------------------------------
		 | -BOOK_ID- | -BOOK_DESCRIPTION- | PRICE  | -BOOK_TITLE- | ILLUSTRATIONS | ISBN | NBOFPAGE | PUBLISHER  |
		 ---------------------------------------------------------------------------------------------------------
		 |   1	     | Description	      |  123.2 | Title	      | true	      | isbn | 324	    |  Publisher |
		 ---------------------------------------------------------------------------------------------------------

		 */
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
