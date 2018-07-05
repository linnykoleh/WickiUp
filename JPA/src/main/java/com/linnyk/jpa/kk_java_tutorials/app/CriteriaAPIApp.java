package com.linnyk.jpa.kk_java_tutorials.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.junit.Test;

import com.linnyk.jpa.kk_java_tutorials.entities.EmployeeKK;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class CriteriaAPIApp {

	@Test
	public void simpleSelection(){
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
	public void attributeSelection(){
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

	@Test
	public void multipleAttributeSelection_1(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		final Root<EmployeeKK> root = criteriaQuery.from(EmployeeKK.class);

		final Path<String> employeeNamePath = root.get("employeeName");
		final Path<String> emailPath = root.get("email");
		final Path<Double> salaryPath = root.get("salary");

		criteriaQuery.select(criteriaBuilder.array(employeeNamePath, emailPath, salaryPath));

		final TypedQuery<Object[]> typedQuery = entityManager.createQuery(criteriaQuery);
		final List<Object[]> resultList = typedQuery.getResultList();

		for(Object[] obj : resultList){
			System.out.println();
			System.out.println("employeeName: " + obj[0]);
			System.out.println("email: " + obj[1]);
			System.out.println("salary: " + obj[2]);
			System.out.println();
		}

		// select e.employee_name, e.email, e.salary from employee_table e
		//
		// employeeName: Martin Bingel
		// email: martin.cs2017@gmail.com
		// salary: 50000.0
		//
		// employeeName: Sean Murphy
		// email: sean.m2017@gmail.com
		// salary: 90000.0

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void multipleAttributeSelection_2(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		final Root<EmployeeKK> root = criteriaQuery.from(EmployeeKK.class);

		final Path<String> employeeNamePath = root.get("employeeName");
		final Path<String> emailPath = root.get("email");
		final Path<Double> salaryPath = root.get("salary");

		// Заюзали multiselect вместо
		// criteriaQuery.select(criteriaBuilder.array(employeeNamePath, emailPath, salaryPath));

		criteriaQuery.multiselect(employeeNamePath, emailPath, salaryPath)
				.where(criteriaBuilder.equal(root.get("employeeId"), 2));

		final TypedQuery<Object[]> typedQuery = entityManager.createQuery(criteriaQuery);
		final List<Object[]> resultList = typedQuery.getResultList();

		for(Object[] obj : resultList){
			System.out.println();
			System.out.println("employeeName: " + obj[0]);
			System.out.println("email: " + obj[1]);
			System.out.println("salary: " + obj[2]);
			System.out.println();
		}

		// select e.employee_name, e.email, e.salary from employee_table e where e.employee_id=2
		//
		// employeeName: Sean Murphy
		// email: sean.m2017@gmail.com
		// salary: 90000.0

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
