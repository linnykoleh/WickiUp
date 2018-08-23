package com.linnyk.jpa.jee7.apps.one_to_one_u;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.id_class.News;
import com.linnyk.jpa.jee7.entities.one_to_one_u.Address;
import com.linnyk.jpa.jee7.entities.one_to_one_u.Customer;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class OneToOneUnidirectional {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Address address = new Address("Street 1", "Street 2", "City", "State", "ZipCode");

		final Customer customer = new Customer("FirstName", "LastName", "Email", "PhoneNumber", address);

		entityManager.persist(customer);
		// insert into ADDRESS_JEE_U (city, state, street1, street2, zipcode, id) values (?, ?, ?, ?, ?, ?)
		// insert into CUSTOMER_JEE_U (address_fk, email, firstName, lastName, phoneNumber, id) values (?, ?, ?, ?, ?, ?)

		/**

		 CUSTOMER_JEE_U
		 -----------------------------------------------------------------
		 | ID | EMAIL  | FIRSTNAME | LASTNAME | PHONENUMBER | ADDRESS_FK |
		 -----------------------------------------------------------------
		 | 1  |	 Email | FirstName | LastName |	PhoneNumber	|     2      |
		 -----------------------------------------------------------------
                                                                  ^
		    											          |
		 		                                                  | ADDRESS_JEE_U
		 														-----------------------------------------------------
														        | ID | CITY | STATE | STREET1  | STREET2  | ZIPCODE |
		 														-----------------------------------------------------
		 														| 2	 | City	| State	| Street 1 | Street 2 |	ZipCode |
		 														-----------------------------------------------------


		 */

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
