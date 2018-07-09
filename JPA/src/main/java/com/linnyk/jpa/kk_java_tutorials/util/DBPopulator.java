package com.linnyk.jpa.kk_java_tutorials.util;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.linnyk.jpa.kk_java_tutorials.entities.EmployeeKK;
import com.linnyk.jpa.kk_java_tutorials.entities.selecting_values_from_multiple_roots.Partner;
import com.linnyk.jpa.kk_java_tutorials.entities.selecting_values_from_multiple_roots.Person;
import com.linnyk.jpa.kk_java_tutorials.entities.selecting_values_from_multiple_roots.Phone;
import com.linnyk.jpa.kk_java_tutorials.entities.selecting_values_from_multiple_roots.PhoneType;
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

		final Person person1 = new Person();
		person1.setName("Mark Bingel");
		person1.setNickName("Mac");
		person1.setAddress("Alameda Street Los Angeles");
		person1.setCreatedOn(new Date());
		person1.setVersion(1);

		final Phone phone1 = new Phone();
		phone1.setNumber("9073637380");
		phone1.setType(PhoneType.MOBILE);
		phone1.setPerson(person1);

		person1.getPhones().add(phone1);

		final Person person2 = new Person();
		person2.setName("Sean Murphy");
		person2.setNickName("Sam");
		person2.setAddress("Bank of Canada,234 Wellington Street");
		person2.setCreatedOn(new Date());
		person2.setVersion(1);

		final Phone phone2 = new Phone();
		phone2.setNumber("809865430");
		phone2.setType(PhoneType.MOBILE);
		phone2.setPerson(person2);

		final Phone phone3 = new Phone();
		phone3.setNumber("022909742");
		phone3.setType(PhoneType.LAND_LINE);
		phone3.setPerson(person2);

		person2.getPhones().add(phone2);
		person2.getPhones().add(phone3);

		final Partner partner = new Partner();
		partner.setName("Sean Murphy");
		partner.setVersion(1);

		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(partner);

		entityManager.persist(employeeKK1);
		entityManager.persist(employeeKK2);

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}