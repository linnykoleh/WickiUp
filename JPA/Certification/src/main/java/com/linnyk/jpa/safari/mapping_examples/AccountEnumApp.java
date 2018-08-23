package com.linnyk.jpa.safari.mapping_examples;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.safari.entities.Account;
import com.linnyk.jpa.safari.entities.AccountType;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import com.linnyk.jpa.safari.util.EntitiesUtil;

public class AccountEnumApp {

    @Test
    public void testEnum() {
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        final Account account = EntitiesUtil.getAccount("Account");
        account.setAccountType(AccountType.SAVING);

        entityManager.persist(account);
        //insert into ACCOUNT (ACCOUNT_ID, ACCOUNT_TYPE, CLOSE_DATE, CREATED_BY, CREATED_DATE, CURRENT_BALANCE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME, OPEN_DATE) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

        transaction.commit();

        final Account dbAccount = entityManager.find(Account.class, account.getAccountId());
        System.out.println(dbAccount.getName()); // Account
        System.out.println(dbAccount.getAccountType()); // SAVING

        entityManager.close();
        entityManagerFactory.close();
    }


}
