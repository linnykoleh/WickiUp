package com.linnyk.jpa.safari.hibernate_api;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.linnyk.jpa.safari.mapping.entities.embedded.Bank;
import com.linnyk.jpa.safari.mapping.util.EntityUtil;
import com.linnyk.jpa.safari.mapping.util.HibernateFactoryCreator;

public class FlushApp {

	@Test
	public void testModifying() {
		final Session session = HibernateFactoryCreator.getSessionFactoryXML().openSession();
		final Transaction transaction = session.beginTransaction();

		try {
			final Bank bank = session.get(Bank.class, 1L);
			// select bank0_.BANK_ID as BANK_ID1_1_0_, bank0_.ADDRESS_LINE_1 as ADDRESS_2_1_0_, bank0_.ADDRESS_LINE_2 as ADDRESS_3_1_0_, bank0_.CITY as CITY4_1_0_, bank0_.STATE as STATE5_1_0_, bank0_.ZIP_CODE as ZIP_CODE6_1_0_, bank0_.CREATED_BY as CREATED_7_1_0_, bank0_.CREATED_DATE as CREATED_8_1_0_, bank0_.IS_INTERNATIONAL as IS_INTER9_1_0_, bank0_.LAST_UPDATED_BY as LAST_UP10_1_0_, bank0_.LAST_UPDATED_DATE as LAST_UP11_1_0_, bank0_.NAME as NAME12_1_0_ from BANK bank0_ where bank0_.BANK_ID=?

			bank.setName("Some bank");
			System.out.println("Calling flush");
			session.flush();
			// update BANK set ADDRESS_LINE_1=?, ADDRESS_LINE_2=?, CITY=?, STATE=?, ZIP_CODE=?, CREATED_BY=?, CREATED_DATE=?, IS_INTERNATIONAL=?, LAST_UPDATED_BY=?, LAST_UPDATED_DATE=?, NAME=? where BANK_ID=?

			bank.setAddressLine1("Another address");
			System.out.println("Calling commit");
			transaction.commit();
			// update BANK set ADDRESS_LINE_1=?, ADDRESS_LINE_2=?, CITY=?, STATE=?, ZIP_CODE=?, CREATED_BY=?, CREATED_DATE=?, IS_INTERNATIONAL=?, LAST_UPDATED_BY=?, LAST_UPDATED_DATE=?, NAME=? where BANK_ID=?

		}catch (Exception e){
			transaction.rollback();
		}finally {
			session.close();
			HibernateFactoryCreator.getSessionFactoryXML().close();
		}

		// Flush данных - синхронизация с базой анных
		// происходит при вызове
		// 1. session.flush();
		// 2. transaction.commit();
	}
}
