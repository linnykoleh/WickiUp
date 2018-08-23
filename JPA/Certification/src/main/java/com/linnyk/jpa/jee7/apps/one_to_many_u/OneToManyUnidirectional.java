package com.linnyk.jpa.jee7.apps.one_to_many_u;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.one_to_many_u.join_column.OrderC;
import com.linnyk.jpa.jee7.entities.one_to_many_u.join_column.OrderLineC;
import com.linnyk.jpa.jee7.entities.one_to_many_u.join_table.OrderT;
import com.linnyk.jpa.jee7.entities.one_to_many_u.join_table.OrderLineT;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class OneToManyUnidirectional {

	@Test
	public void test_JoinTable(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final OrderLineT orderLineT1 = new OrderLineT("Item 1", 21.3, 23);
		final OrderLineT orderLineT2 = new OrderLineT("Item 2", 23.6, 12);
		final OrderLineT orderLineT3 = new OrderLineT("Item 3", 76.2, 62);

		final OrderT orderT = new OrderT(new Date(), Arrays.asList(orderLineT1, orderLineT2, orderLineT3));

		entityManager.persist(orderT);
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
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final OrderLineC orderLineC1 = new OrderLineC("Item 1", 21.3, 23);
		final OrderLineC orderLineC2 = new OrderLineC("Item 2", 23.6, 12);
		final OrderLineC orderLineC3 = new OrderLineC("Item 3", 76.2, 62);

		final OrderC orderC = new OrderC(new Date(), Arrays.asList(orderLineC1, orderLineC2, orderLineC3));

		entityManager.persist(orderC);
		// insert into ORDER_C (creationDate, id) values (?, ?)
		//
		// insert into ORDER_LINE_C (item, quantity, unitPrice, id) values (?, ?, ?, ?)
		// insert into ORDER_LINE_C (item, quantity, unitPrice, id) values (?, ?, ?, ?)
		// insert into ORDER_LINE_C (item, quantity, unitPrice, id) values (?, ?, ?, ?)
		//
		// update ORDER_LINE_C set FK_ORDER=? where id=?
		// update ORDER_LINE_C set FK_ORDER=? where id=?
		// update ORDER_LINE_C set FK_ORDER=? where id=?

		/**

		 ORDER_LINE_C                                                      ORDER_C
		 ---------------------------------------------------               --------------------------------------
		 | ID | ITEM   |  QUANTITY |  UNITPRICE | FK_ORDER |               | ID | CREATIONDATE                  |
		 ---------------------------------------------------               --------------------------------------
		 | 2  |	Item 1 |    23	   |    21.3	|	 1     |  <----------- | 1	| 2018-06-01 14:33:19.078000000 |
		 | 3  |	Item 2 |	12	   |    23.6	|	 1     |               --------------------------------------
		 | 4  |	Item 3 |	62	   |    76.2	|	 1     |
		 ---------------------------------------------------

		 */

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
