package com.linnyk.jpa.certification.apps.map_extended.map_key_join_column;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.certification.entities.map_extended.map_key_join_column.Department;
import com.linnyk.jpa.certification.entities.map_extended.map_key_join_column.Employee;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class MapApp {

	@Test
	public void mapKeyJoinColumn(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Employee employee1 = new Employee("JOHN");
		final Employee employee2 = new Employee("MARK");
		final Employee employee3 = new Employee("ALAN");

		final Department department = new Department();

		department.getEmployees().put(employee1, BigDecimal.valueOf(7777));
		department.getEmployees().put(employee2, BigDecimal.valueOf(8888));
		department.getEmployees().put(employee3, BigDecimal.valueOf(9999));

		employee1.setDepartment(department);
		employee2.setDepartment(department);
		employee3.setDepartment(department);

		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);

		entityManager.persist(department);

		transaction.commit();

		// insert into EMPLOYEE_MKJC (department_id, EMPLOYEE_NAME, EMPLOYEE_ID) values (?, ?, ?)
		// insert into EMPLOYEE_MKJC (department_id, EMPLOYEE_NAME, EMPLOYEE_ID) values (?, ?, ?)
		// insert into EMPLOYEE_MKJC (department_id, EMPLOYEE_NAME, EMPLOYEE_ID) values (?, ?, ?)
		//
		// insert into DEPARTMENT_MKJC (DEPARTMENT_NAME, id) values (?, ?)
		//
		// update EMPLOYEE_MKJC set department_id=?, EMPLOYEE_NAME=? where EMPLOYEE_ID=?
		// update EMPLOYEE_MKJC set department_id=?, EMPLOYEE_NAME=? where EMPLOYEE_ID=?
		// update EMPLOYEE_MKJC set department_id=?, EMPLOYEE_NAME=? where EMPLOYEE_ID=?
		//
		// insert into EMPLOYEES_INFO_MKJC (Department_id, EMPLOYEE_ID_MKJC, EMPLOYEE_SALARY) values (?, ?, ?)
		// insert into EMPLOYEES_INFO_MKJC (Department_id, EMPLOYEE_ID_MKJC, EMPLOYEE_SALARY) values (?, ?, ?)
		// insert into EMPLOYEES_INFO_MKJC (Department_id, EMPLOYEE_ID_MKJC, EMPLOYEE_SALARY) values (?, ?, ?)

		entityManager.close();
		entityManagerFactory.close();
	}

}
