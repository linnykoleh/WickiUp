package com.linnyk.jpa.jee7.apps.cache;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.cache.Customer;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class CustomerApp {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Customer customer = new Customer("Патриция", "Джейн", "plecomte@mail.com");
		entityManager.persist(customer);
		// insert into Customer (email, firstName, lastName, id) values (?, ?, ?, ?)
		transaction.commit();

		transaction.begin();
		// Использует EntityManagerFactory для получения Cache
		Cache cache = entityManagerFactory.getCache();

		// Сущность Customer должна располагаться в кэше
		System.out.println("Customer is in cache: " + cache.contains(Customer.class, customer.getId())); //true

		// Удаляет сущность Customer из кэша
		cache.evict(Customer.class);
		System.out.println("Evict Customer from cache");

		// Сущность Customer больше не должна располагаться в кэше
		System.out.println("Customer is in cache: " + cache.contains(Customer.class, customer.getId())); //false

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}