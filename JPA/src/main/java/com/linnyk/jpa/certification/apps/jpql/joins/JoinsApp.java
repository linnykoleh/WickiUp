package com.linnyk.jpa.certification.apps.jpql.joins;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.certification.entities.jpql.joins.Customer;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class JoinsApp {

    /**

     insert into CUSTOMER_J (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, STATE, ZIPCODE)
     values (1, 'George',	'Washington', 'gwashington@usa.gov',	'3200 Mt Vernon Hwy',	'Mount Vernon',	'VA',	22121);
     insert into CUSTOMER_J (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, STATE, ZIPCODE)
     values (2, 'John',	'Adams',	'jadams@usa.gov',	'1250 Hancock St',	'Quincy',	'MA',	02169);
     insert into CUSTOMER_J (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, STATE, ZIPCODE)
     values (3,	'Thomas',	'Jefferson',	'tjefferson@usa.gov',	'931 Thomas Jefferson Pkwy',	'Charlottesville',	'VA',	22902);
     insert into CUSTOMER_J (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, STATE, ZIPCODE)
     values (4, 'James',	'Madison',	'jmadison@usa.gov',	'11350 Constitution Hwy',	'Orange',	'VA',	22960);
     insert into CUSTOMER_J (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS, CITY, STATE, ZIPCODE)
     values (5,	'James',	'Monroe',	'jmonroe@usa.gov',	'2050 James Monroe Parkway',	'Charlottesville', 'VA',	22902);

     insert into ORDER_J(ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
     values (1,	'07/04/1776',	234.56,	1);
     insert into ORDER_J(ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
     values (2,	'03/14/1760',	78.50,	3);
     insert into ORDER_J (ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
     values (3, '05/23/1784', 124.00, 2);
     insert into ORDER_J(ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
     values (4, '09/03/1790',	65.50,	3);
     insert into ORDER_J (ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
     values (5, '07/21/1795', 25.50, 10);
     insert into ORDER_J(ORDER_ID, ORDER_DATE, AMOUNT, CUSTOMER_ID)
     values ( 6,	'11/27/1787',	14.40,	9);

      */

    @Test
    public void testSimpleJPQLSelect(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Customer> resultList =
                entityManager.createQuery("select c from CustomerJ c", Customer.class).getResultList();
        /*
        select * from CUSTOMER_J customer0_
        select * from ORDER_J order0_ where order0_.CUSTOMER_ID=?
        select * from ORDER_J order0_ where order0_.CUSTOMER_ID=?
        select * from ORDER_J order0_ where order0_.CUSTOMER_ID=?
        select * from ORDER_J order0_ where order0_.CUSTOMER_ID=?
        select * from ORDER_J order0_ where order0_.CUSTOMER_ID=?

        [Customer(id=1, firstName=George, lastName=Washington, email=gwashington@usa.gov, address=3200 Mt Vernon Hwy, city=Mount Vernon, state=VA, zipCode=22121, order=[Order(id=1, orderDate=07/04/1776, amount=234.56)]), Customer(id=2, firstName=John, lastName=Adams, email=jadams@usa.gov, address=1250 Hancock St, city=Quincy, state=MA, zipCode=2169, order=[Order(id=3, orderDate=05/23/1784, amount=124.00)]), Customer(id=3, firstName=Thomas, lastName=Jefferson, email=tjefferson@usa.gov, address=931 Thomas Jefferson Pkwy, city=Charlottesville, state=VA, zipCode=22902, order=[Order(id=2, orderDate=03/14/1760, amount=78.50), Order(id=4, orderDate=09/03/1790, amount=65.50)]), Customer(id=4, firstName=James, lastName=Madison, email=jmadison@usa.gov, address=11350 Constitution Hwy, city=Orange, state=VA, zipCode=22960, order=[]), Customer(id=5, firstName=James, lastName=Monroe, email=jmonroe@usa.gov, address=2050 James Monroe Parkway, city=Charlottesville, state=VA, zipCode=22902, order=[])]
        */
        System.out.println(resultList);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void testInnerJoin(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Customer> resultList =
                entityManager.createQuery("select c from CustomerJ c JOIN c.order o", Customer.class).getResultList();
        /*
        select *
        from CUSTOMER_J customer0_
        inner join ORDER_J order1_ on customer0_.CUSTOMER_ID=order1_.CUSTOMER_ID

        ... Some sql selects for order entity
        */
        System.out.println(resultList);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void testJoinUsingIN(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Customer> resultList =
                entityManager.createQuery("select c from CustomerJ c, IN(c.order) o", Customer.class).getResultList();
        /*

        select *
        from CUSTOMER_J customer0_
        inner join ORDER_J order1_ on customer0_.CUSTOMER_ID=order1_.CUSTOMER_ID

        ... Some sql selects for order entity
        */
        System.out.println(resultList);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void testJoinUsingFETCH(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Customer> resultList =
                entityManager.createQuery("select c from CustomerJ c join fetch c.order", Customer.class).getResultList();
        /*

        Only one select

        select *
        from CUSTOMER_J customer0_
        inner join ORDER_J order1_ on customer0_.CUSTOMER_ID=order1_.CUSTOMER_ID

        [Customer(id=1, firstName=George, lastName=Washington, email=gwashington@usa.gov, address=3200 Mt Vernon Hwy, city=Mount Vernon, state=VA, zipCode=22121, order=[Order(id=1, orderDate=07/04/1776, amount=234.56)]), Customer(id=3, firstName=Thomas, lastName=Jefferson, email=tjefferson@usa.gov, address=931 Thomas Jefferson Pkwy, city=Charlottesville, state=VA, zipCode=22902, order=[Order(id=2, orderDate=03/14/1760, amount=78.50), Order(id=4, orderDate=09/03/1790, amount=65.50)]), Customer(id=2, firstName=John, lastName=Adams, email=jadams@usa.gov, address=1250 Hancock St, city=Quincy, state=MA, zipCode=2169, order=[Order(id=3, orderDate=05/23/1784, amount=124.00)]), Customer(id=3, firstName=Thomas, lastName=Jefferson, email=tjefferson@usa.gov, address=931 Thomas Jefferson Pkwy, city=Charlottesville, state=VA, zipCode=22902, order=[Order(id=2, orderDate=03/14/1760, amount=78.50), Order(id=4, orderDate=09/03/1790, amount=65.50)])]
        */
        System.out.println(resultList);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
