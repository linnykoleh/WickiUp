package com.linnyk.jpa.safari.hibernate_api;

import org.hibernate.Session;
import org.junit.Test;

import com.linnyk.jpa.safari.mapping.entities.embedded.Bank;
import com.linnyk.jpa.safari.mapping.util.EntityUtil;
import com.linnyk.jpa.safari.mapping.util.HibernateFactoryCreator;

public class RemoveApp {

	@Test
	public void testRemoving() {
		final Session session = HibernateFactoryCreator.getSessionFactoryXML().openSession();

		try{
			final org.hibernate.Transaction transaction = session.beginTransaction();

			Bank bank = session.get(Bank.class, 1L); //Persistent state

			System.out.println(session.contains(bank)); //true

			session.delete(bank); //Deleted state

			System.out.println("Method invoked");
			System.out.println(session.contains(bank)); //false

			transaction.commit();

			//select bank0_.BANK_ID as BANK_ID1_1_0_, bank0_.ADDRESS_LINE_1 as ADDRESS_2_1_0_, bank0_.ADDRESS_LINE_2 as ADDRESS_3_1_0_, bank0_.CITY as CITY4_1_0_, bank0_.STATE as STATE5_1_0_, bank0_.ZIP_CODE as ZIP_CODE6_1_0_, bank0_.CREATED_BY as CREATED_7_1_0_, bank0_.CREATED_DATE as CREATED_8_1_0_, bank0_.IS_INTERNATIONAL as IS_INTER9_1_0_, bank0_.LAST_UPDATED_BY as LAST_UP10_1_0_, bank0_.LAST_UPDATED_DATE as LAST_UP11_1_0_, bank0_.NAME as NAME12_1_0_ from BANK bank0_ where bank0_.BANK_ID=?
			//true
			//Method invoked
			//false
			//Hibernate: delete from BANK_CONTACT where BANK_ID=?
			//Hibernate: delete from BANK where BANK_ID=?
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			HibernateFactoryCreator.getSessionFactoryXML().close();
			session.close();
		}
	}
}
