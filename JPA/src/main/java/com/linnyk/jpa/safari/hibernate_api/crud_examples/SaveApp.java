package com.linnyk.jpa.safari.hibernate_api.crud_examples;

import org.hibernate.Session;
import org.junit.Test;

import com.linnyk.jpa.safari.entities.Account;
import com.linnyk.jpa.safari.entities.association.Transaction;
import com.linnyk.jpa.safari.util.EntitiesUtil;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;

public class SaveApp {

	@Test
	public void testSaving() {
		final Session session = HibernateFactoryBuilder.getSessionFactoryXML().openSession();

		final Account account = EntitiesUtil.getAccount("Account");
		final Transaction tran1 = EntitiesUtil.getTransaction("Transaction 1", "Fire");
		final Transaction tran2 = EntitiesUtil.getTransaction("Transaction 2", "Fire");

		account.getTransactions().add(tran1);
		account.getTransactions().add(tran2);

		tran1.setAccount(account);
		tran2.setAccount(account);
		//Transient

		System.out.println(session.contains(account)); //false
		System.out.println(session.contains(tran1));   //false
		System.out.println(session.contains(tran2));   //false

		final org.hibernate.Transaction transaction = session.beginTransaction();
		try{
			session.save(account);
			//Persistent

			//insert into ACCOUNT (ACCOUNT_ID, CLOSE_DATE, CREATED_BY, CREATED_DATE, CURRENT_BALANCE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME, OPEN_DATE) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)
			//insert into TRANSACTION (TRANSACTION_ID, ACCOUNT_ID, AMOUNT, CLOSING_BALANCE, CREATED_BY, CREATED_DATE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NOTES, TITLE, TRANSACTION_TYPE) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
			//insert into TRANSACTION (TRANSACTION_ID, ACCOUNT_ID, AMOUNT, CLOSING_BALANCE, CREATED_BY, CREATED_DATE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NOTES, TITLE, TRANSACTION_TYPE) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

			System.out.println(session.contains(account)); //true
			System.out.println(session.contains(tran1));   //true
			System.out.println(session.contains(tran2));   //true

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			transaction.commit();
			session.close();
		}
	}
}
