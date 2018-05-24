package com.linnyk.jpa.safari.mapping_examples.inheritance_2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.linnyk.jpa.safari.entities.inheritance_2._1.BankAccount1;
import com.linnyk.jpa.safari.entities.inheritance_2._1.CreditCard1;
import com.linnyk.jpa.safari.entities.inheritance_2._2.BankAccount2;
import com.linnyk.jpa.safari.entities.inheritance_2._2.CreditCard2;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;

public class InheritanceApp {

	@Test
	public void test_1(){
		final SessionFactory sessionFactory = HibernateFactoryBuilder.getSessionFactoryXML();
		final Session session = sessionFactory.openSession();
		final Transaction transaction = session.getTransaction();
		transaction.begin();

		final CreditCard1 creditCard1 = new CreditCard1();
		creditCard1.setCardNumber(44411111);
		creditCard1.setExpMonth("Jan");
		creditCard1.setExpYear("2017");
		creditCard1.setOwner("Bill Gates");

		final BankAccount1 bankAccount1 = new BankAccount1();
		bankAccount1.setAccount(111222333);
		bankAccount1.setBankName("Goldman Sachs");
		bankAccount1.setSwift("GOLDUS33");
		bankAccount1.setOwner("Donald Trump");

		session.persist(creditCard1);
		session.persist(bankAccount1);
//		insert into CREDIT_CARD_1 (owner, card_number, exp_month, exp_year, id) values (?, ?, ?, ?, ?)
//		insert into BANK_ACCOUNT_1 (owner, account, bank_name, swift, id) values (?, ?, ?, ?, ?)

		final Query query = session.createQuery("select ba from BankAccount1 ba");
		final List resultList = query.getResultList();

		for(Object obj : resultList){
			System.out.println(obj);
		}
		//BankAccount1{account=111222333, bankName='Goldman Sachs', swift='GOLDUS33'}
		//BankAccount1{account=111222333, bankName='Goldman Sachs', swift='GOLDUS33'}

		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void test_2(){
		final SessionFactory sessionFactory = HibernateFactoryBuilder.getSessionFactoryXML();
		final Session session = sessionFactory.openSession();
		final Transaction transaction = session.getTransaction();
		transaction.begin();

		final CreditCard2 creditCard2 = new CreditCard2();
		creditCard2.setCardNumber(44411111);
		creditCard2.setExpMonth("Jan");
		creditCard2.setExpYear("2017");
		creditCard2.setOwner("Bill Gates");

		final BankAccount2 bankAccount2 = new BankAccount2();
		bankAccount2.setAccount(111222333);
		bankAccount2.setBankName("Goldman Sachs");
		bankAccount2.setSwift("GOLDUS33");
		bankAccount2.setOwner("Donald Trump");

		session.persist(creditCard2);
		session.persist(bankAccount2);

//		insert into CREDIT_CARD_2 (owner, card_number, exp_month, exp_year, id) values (?, ?, ?, ?, ?)
//		insert into BANK_ACCOUNT_2 (owner, account, bank_name, swift, id) values (?, ?, ?, ?, ?)

		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
