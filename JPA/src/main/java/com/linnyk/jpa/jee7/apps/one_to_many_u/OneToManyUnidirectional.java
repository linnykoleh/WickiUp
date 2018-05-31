package com.linnyk.jpa.jee7.apps.one_to_many_u;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.one_to_many_u.join_table.Order;
import com.linnyk.jpa.jee7.entities.one_to_many_u.join_table.OrderLine;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class OneToManyUnidirectional {

	@Test
	public void test_JoinTable(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final OrderLine orderLine1 = new OrderLine("Item 1", 21.3, 23);
		final OrderLine orderLine2 = new OrderLine("Item 2", 23.6, 12);
		final OrderLine orderLine3 = new OrderLine("Item 3", 76.2, 62);

		final Order order = new Order(new Date(), Arrays.asList(orderLine1, orderLine2, orderLine3));

		entityManager.persist(order);
		// insert into ORDER_T (creationDate, id) values (?, ?)
		//
		// insert into ORDER_LINE_T (item, quantity, unitPrice, id) values (?, ?, ?, ?)
		// insert into ORDER_LINE_T (item, quantity, unitPrice, id) values (?, ?, ?, ?)
		// insert into ORDER_LINE_T (item, quantity, unitPrice, id) values (?, ?, ?, ?)
		//
		// insert into ORDER_TO_ORDER_LINE (order_fk, order_line_fk) values (?, ?)
		// insert into ORDER_TO_ORDER_LINE (order_fk, order_line_fk) values (?, ?)
		// insert into ORDER_TO_ORDER_LINE (order_fk, order_line_fk) values (?, ?)

		/**

		      -----------------------------------------------------------|
		 	  |															 |
		 ----------------------------									 |
		 | ORDER_FK | ORDER_LINE_FK |								     |
		 ----------------------------							         |
		 |   1		|	  2         |									 |
		 |   1		|	  3         |									 |
		 |   1	 	|	  4         |								     |
		 ----------------------------									 |
						   |											 |
		  |-----------------											 |
		  |															     |
		  |   DER_LINE_T												 |    ORDER_T
		--------------------------------------							 |    ---------------------------------------
		| ID | ITEM   |	QUANTITY | UNITPRICE |                           ---- | ID  |  CREATIONDATE                 |
		--------------------------------------                                ---------------------------------------
		| 2	 | Item 1 |	   23	 |   21.3    |                                | 1	| 2018-05-31 17:15:15.417000000 |
		| 3	 | Item 2 |	   12	 |   23.6    |                                ---------------------------------------
		| 4	 | Item 3 |	   62	 |   76.2    |
		-------------------------------------

		 */

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void test_JoinColumn(){

	}
}
