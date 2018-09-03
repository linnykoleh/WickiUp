package com.linnyk.jpa.safari.jpa_api.crud_examples;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.safari.entities.embedded.Bank;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import com.linnyk.jpa.safari.util.EntitiesUtil;

public class MergeApp {

	@Test
	public void testMerge_save() {
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		final Bank bank = EntitiesUtil.getBank("My JPA Bank");
		entityManager.persist(bank);
		// insert into BANK (BANK_ID, ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, CREATED_BY, CREATED_DATE, IS_INTERNATIONAL, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

		transaction.commit();
		entityManager.close();

		final EntityManager entityManager1 = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction1 = entityManager1.getTransaction();

		transaction1.begin();

		final Bank bankMerged = EntitiesUtil.getBank("My JPA Bank Merged");
		entityManager1.merge(bankMerged);
		// insert into BANK (BANK_ID, ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, CREATED_BY, CREATED_DATE, IS_INTERNATIONAL, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

		transaction1.commit();
		entityManager1.close();

		entityManagerFactory.close();
	}

	@Test
	public void testMerge_update() {
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		final Bank bank = EntitiesUtil.getBank("My JPA Bank");
		entityManager.persist(bank);
		// insert into BANK (BANK_ID, ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, CREATED_BY, CREATED_DATE, IS_INTERNATIONAL, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

		transaction.commit();
		entityManager.close();

		final EntityManager entityManager1 = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction1 = entityManager1.getTransaction();

		transaction1.begin();

		final Bank bankMerged = EntitiesUtil.getBank("My JPA Bank Merges");
		bankMerged.setBankId(bank.getBankId());
		entityManager1.merge(bankMerged);

		// select BANK_ID as BANK_ID1_4_2_, ACCOUNT_ID as ACCOUNT13_4_2_, ADDRESS_LINE_1 as ADDRESS_2_4_2_, ADDRESS_LINE_2 as ADDRESS_3_4_2_, CITY as CITY4_4_2_, STATE as STATE5_4_2_, ZIP_CODE as ZIP_CODE6_4_2_, CREATED_BY as CREATED_7_4_2_, CREATED_DATE as CREATED_8_4_2_, IS_INTERNATIONAL as IS_INTER9_4_2_, LAST_UPDATED_BY as LAST_UP10_4_2_, LAST_UPDATED_DATE as LAST_UP11_4_2_, NAME as NAME12_4_2_, account1_.ACCOUNT_ID as ACCOUNT_1_0_0_, account1_.ACCOUNT_TYPE as ACCOUNT_2_0_0_, account1_.CLOSE_DATE as CLOSE_DA3_0_0_, account1_.CREATED_BY as CREATED_4_0_0_, account1_.CREATED_DATE as CREATED_5_0_0_, account1_.CURRENT_BALANCE as CURRENT_6_0_0_, account1_.INITIAL_BALANCE as INITIAL_7_0_0_, account1_.LAST_UPDATED_BY as LAST_UPD8_0_0_, account1_.LAST_UPDATED_DATE as LAST_UPD9_0_0_, account1_.NAME as NAME10_0_0_, account1_.OPEN_DATE as OPEN_DA11_0_0_, transactio2_.ACCOUNT_ID as ACCOUNT12_96_4_, transactio2_.TRANSACTION_ID as TRANSACT1_96_4_, transactio2_.TRANSACTION_ID as TRANSACT1_96_1_, transactio2_.ACCOUNT_ID as ACCOUNT12_96_1_, transactio2_.AMOUNT as AMOUNT2_96_1_, transactio2_.CLOSING_BALANCE as CLOSING_3_96_1_, transactio2_.CREATED_BY as CREATED_4_96_1_, transactio2_.CREATED_DATE as CREATED_5_96_1_, transactio2_.INITIAL_BALANCE as INITIAL_6_96_1_, transactio2_.LAST_UPDATED_BY as LAST_UPD7_96_1_, transactio2_.LAST_UPDATED_DATE as LAST_UPD8_96_1_, transactio2_.NOTES as NOTES9_96_1_, transactio2_.TITLE as TITLE10_96_1_, transactio2_.TRANSACTION_TYPE as TRANSAC11_96_1_ from BANK bank0_ left outer join ACCOUNT account1_ on ACCOUNT_ID=account1_.ACCOUNT_ID left outer join TRANSACTION transactio2_ on account1_.ACCOUNT_ID=transactio2_.ACCOUNT_ID
		// 		where BANK_ID=?
		// select contacts0_.BANK_ID as BANK_ID1_8_0_, contacts0_.NAME as NAME2_8_0_ from BANK_CONTACT_COLLECTION contacts0_ where contacts0_.BANK_ID=?
		// select contactsma0_.BANK_ID as BANK_ID1_9_0_, contactsma0_.NAME as NAME2_9_0_, contactsma0_.POSITION_TYPE as POSITION3_0_ from BANK_CONTACT_MAP contactsma0_ where contactsma0_.BANK_ID=?
		// update BANK set ACCOUNT_ID=?, ADDRESS_LINE_1=?, ADDRESS_LINE_2=?, CITY=?, STATE=?, ZIP_CODE=?, CREATED_BY=?, CREATED_DATE=?, IS_INTERNATIONAL=?, LAST_UPDATED_BY=?, LAST_UPDATED_DATE=?, NAME=?
		// 		where BANK_ID=?

		transaction1.commit();
		entityManager1.close();

		entityManagerFactory.close();
	}
}
