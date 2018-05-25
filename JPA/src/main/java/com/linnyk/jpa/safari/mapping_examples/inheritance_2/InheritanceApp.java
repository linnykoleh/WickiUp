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
import com.linnyk.jpa.safari.entities.inheritance_2._3.BankAccount3;
import com.linnyk.jpa.safari.entities.inheritance_2._3.BillingDetails3;
import com.linnyk.jpa.safari.entities.inheritance_2._3.CreditCard3;
import com.linnyk.jpa.safari.entities.inheritance_2._4.BankAccount4;
import com.linnyk.jpa.safari.entities.inheritance_2._4.BillingDetails4;
import com.linnyk.jpa.safari.entities.inheritance_2._4.CreditCard4;
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

		final Query query = session.createQuery("select bd from BillingDetails2 bd");
		final List resultList = query.getResultList();
		// select billingdet0_.id as id1_5_, billingdet0_.owner as owner2_5_, billingdet0_.account as account1_3_, billingdet0_.bank_name as bank_nam2_3_, billingdet0_.swift as swift3_3_, billingdet0_.card_number as card_num1_10_, billingdet0_.exp_month as exp_mont2_10_, billingdet0_.exp_year as exp_year3_10_, billingdet0_.clazz_ as clazz_
		// from (
		//        select id, owner, account, bank_name, swift, null as card_number, null as exp_month, null as exp_year, 1 as clazz_
		//        from
		//             BANK_ACCOUNT_2
		//        union all
		//             select id, owner, null as account, null as bank_name, null as swift, card_number, exp_month, exp_year, 2 as clazz_
		//        from
		//             CREDIT_CARD_2
		// ) billingdet0_

		for(Object obj : resultList){
			System.out.println(obj);
		}
		// BankAccount1{account=111222333, bankName='Goldman Sachs', swift='GOLDUS33'}
		// BankAccount1{account=111222333, bankName='Goldman Sachs', swift='GOLDUS33'}
		// BankAccount1{account=111222333, bankName='Goldman Sachs', swift='GOLDUS33'}
		// BankAccount1{account=111222333, bankName='Goldman Sachs', swift='GOLDUS33'}
		// BankAccount1{account=111222333, bankName='Goldman Sachs', swift='GOLDUS33'}
		// BankAccount1{account=111222333, bankName='Goldman Sachs', swift='GOLDUS33'}
		// CreditCard1{cardNumber=44411111, expMonth='Jan', expYear='2017'}
		// CreditCard1{cardNumber=44411111, expMonth='Jan', expYear='2017'}
		// CreditCard1{cardNumber=44411111, expMonth='Jan', expYear='2017'}
		// CreditCard1{cardNumber=44411111, expMonth='Jan', expYear='2017'}
		// CreditCard1{cardNumber=44411111, expMonth='Jan', expYear='2017'}
		// CreditCard1{cardNumber=44411111, expMonth='Jan', expYear='2017'}

		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void test_3(){
		final SessionFactory sessionFactory = HibernateFactoryBuilder.getSessionFactoryXML();
		final Session session = sessionFactory.openSession();
		final Transaction transaction = session.getTransaction();
		transaction.begin();

		final CreditCard3 creditCard3 = new CreditCard3();
		creditCard3.setCardNumber(44411111);
		creditCard3.setExpMonth("Jan");
		creditCard3.setExpYear("2017");
		creditCard3.setOwner("Bill Gates");

		final BankAccount3 bankAccount3 = new BankAccount3();
		bankAccount3.setAccount(111222333);
		bankAccount3.setBankName("Goldman Sachs");
		bankAccount3.setSwift("GOLDUS33");
		bankAccount3.setOwner("Donald Trump");

		session.persist(creditCard3);
		session.persist(bankAccount3);

		final Query query = session.createQuery("select bd from BillingDetails3 bd");
		final List<BillingDetails3> resultList = query.getResultList();

		// select billingdet0_.id as id2_5_, billingdet0_.owner as owner3_5_, billingdet0_.account as account4_5_, billingdet0_.bank_name as bank_nam5_5_, billingdet0_.swift as swift6_5_, billingdet0_.card_number as card_num7_5_, billingdet0_.exp_month as exp_mont8_5_, billingdet0_.exp_year as exp_year9_5_, billingdet0_.BD_TYPE as BD_TYPE1_5_
		// from BILLING_DETAILS billingdet0_

		for(BillingDetails3 details3 : resultList){
			System.out.println(details3);
		}
		// CreditCard3{cardNumber=44411111, expMonth='Jan', expYear='2017'}
		// BankAccount3{account=111222333, bankName='Goldman Sachs', swift='GOLDUS33'}

		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void test_4(){
		final SessionFactory sessionFactory = HibernateFactoryBuilder.getSessionFactoryXML();
		final Session session = sessionFactory.openSession();
		final Transaction transaction = session.getTransaction();
		transaction.begin();

		final CreditCard4 creditCard4 = new CreditCard4();
		creditCard4.setCardNumber(44411111);
		creditCard4.setExpMonth("Jan");
		creditCard4.setExpYear("2017");
		creditCard4.setOwner("Bill Gates");

		final BankAccount4 bankAccount4 = new BankAccount4();
		bankAccount4.setAccount(111222333);
		bankAccount4.setBankName("Goldman Sachs");
		bankAccount4.setSwift("GOLDUS33");
		bankAccount4.setOwner("Donald Trump");

		session.persist(creditCard4);
		session.persist(bankAccount4);

//		insert into BILLING_DETAILS_4 (owner, id) values (?, ?)
//		insert into CREDIT_CARD_4 (card_number, exp_month, exp_year, id) values (?, ?, ?, ?)
//		insert into BILLING_DETAILS_4 (owner, id) values (?, ?)
//		insert into BANK_ACCOUNT_4 (account, bank_name, swift, id) values (?, ?, ?, ?)

		final Query query = session.createQuery("select bd from BillingDetails4 bd");
		final List<BillingDetails4> resultList = query.getResultList();

		for(BillingDetails4 details4 : resultList){
			System.out.println(details4);
		}

		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
