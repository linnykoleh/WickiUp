package com.linnyk.jpa.certification.apps.map_extended.map_key_column;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.certification.entities.map_extended.map_key_column.Department;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class MapApp {

	@Test
	public void mapKeyColumn(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Department department = new Department("Dep#1");
		department.getEmployees().put("JOHN", BigDecimal.valueOf(10000));
		department.getEmployees().put("MARK", BigDecimal.valueOf(15000));
		department.getEmployees().put("ALAN", BigDecimal.valueOf(20000));

		entityManager.persist(department);

		transaction.commit();

		// insert into DEPARTMENT_MKC (DEPARTMENT_NAME, id) values (?, ?)
		//
		// insert into EMPLOYEE_INFO (Department_id, EMPLOYEE_NAME, EMPLOYEE_SALARY) values (?, ?, ?)
		// insert into EMPLOYEE_INFO (Department_id, EMPLOYEE_NAME, EMPLOYEE_SALARY) values (?, ?, ?)
		// insert into EMPLOYEE_INFO (Department_id, EMPLOYEE_NAME, EMPLOYEE_SALARY) values (?, ?, ?)

		entityManager.close();
		entityManagerFactory.close();
	}

}
