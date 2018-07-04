package com.linnyk.jpa.kk_java_tutorials.util;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.linnyk.jpa.kk_java_tutorials.entities.EmployeeKK;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class DBPopulator {

	public static void main(String[] args) {
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final EmployeeKK employeeKK1 = new EmployeeKK();
		employeeKK1.setEmployeeName("Martin Bingel");
		employeeKK1.setEmail("martin.cs2017@gmail.com");
		employeeKK1.setSalary(50000.00);
		employeeKK1.setDoj(new Date());

		final EmployeeKK employeeKK2 = new EmployeeKK();
		employeeKK2.setEmployeeName("Sean Murphy");
		employeeKK2.setEmail("sean.m2017@gmail.com");
		employeeKK2.setSalary(90000.00);
		employeeKK2.setDoj(new Date());

		entityManager.persist(employeeKK1);
		entityManager.persist(employeeKK2);

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}