package com.linnyk.jpa.kk_java_tutorials.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;

import com.linnyk.jpa.kk_java_tutorials.entities.EmployeeKK;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class CriteriaAPIApp {

	@Test
	public void testSimpleSelection(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<EmployeeKK> criteriaQuery = criteriaBuilder.createQuery(EmployeeKK.class);
		final Root<EmployeeKK> root = criteriaQuery.from(EmployeeKK.class);

		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("employeeId"), 2));

		final TypedQuery<EmployeeKK> typedQuery = entityManager.createQuery(criteriaQuery);
		final List<EmployeeKK> resultList = typedQuery.getResultList();

		System.out.println(resultList);
		// select e from employee_table e where e.employee_id=2
		// [EmployeeKK(employeeId=2, employeeName=Sean Murphy, email=sean.m2017@gmail.com, doj=2018-07-04 17:49:32.843, salary=90000.0)]

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void testAttributeSelection(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		final Root<EmployeeKK> root = criteriaQuery.from(EmployeeKK.class);

		criteriaQuery.select(root.get("employeeName"));
		criteriaQuery.where(criteriaBuilder.equal(root.get("employeeId"), 2));

		final TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);
		final List<String> resultList = typedQuery.getResultList();

		System.out.println(resultList);
		// select e.employee_name from employee_table e where e.employee_id=2
		// [Sean Murphy]

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
