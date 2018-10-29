package com.linnyk.jpa.jee7.apps.version;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.version.Book;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class BookApp {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		final Book book = new Book("H2G2", 21f, "Лучшая IT-книга", "123-456", 321, false);

		transaction.begin();
		entityManager.persist(book);
		transaction.commit();
		// insert into BOOK_VERSION (id, description, illustrations, isbn, nbOfPage, price, title, version) values (null, ?, ?, ?, ?, ?, ?, ?)

		System.out.println("Book version is : " + book.getVersion()); //1

		transaction.begin();
		book.raisePriceByTwoDollars();
		transaction.commit();
		// update BOOK_VERSION set description=?, illustrations=?, isbn=?, nbOfPage=?, price=?, title=?, version=? where id=? and version=?

		System.out.println("Book version is : " + book.getVersion()); //2

		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void testUpdate(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();

		final Book book = new Book("H2G2", 21f, "Лучшая IT-книга", "123-456", 321, false);

		transaction.begin();
		entityManager.persist(book);
		transaction.commit();
		// insert into BOOK_VERSION (id, description, illustrations, isbn, nbOfPage, price, title, version) values (null, ?, ?, ?, ?, ?, ?, ?)

		System.out.println("Book version is : " + book.getVersion()); //1

		final EntityTransaction transaction1 = entityManager.getTransaction();
		transaction1.begin();
		book.setPrice(111.0F);
		final Book merge = entityManager.merge(book);
		System.out.println(merge);

		transaction1.commit();
		// update BOOK_VERSION set description=?, illustrations=?, isbn=?, nbOfPage=?, price=?, title=?, version=? where id=? and version=?
		System.out.println("Book version is : " + book.getVersion()); //2

		entityManager.close();
		entityManagerFactory.close();
	}

}
