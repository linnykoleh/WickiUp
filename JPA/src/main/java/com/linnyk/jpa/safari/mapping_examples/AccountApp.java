package com.linnyk.jpa.safari.mapping_examples;

import com.linnyk.jpa.safari.entities.User;
import com.linnyk.jpa.safari.entities.Account;
import com.linnyk.jpa.safari.entities.association.Transaction;
import com.linnyk.jpa.safari.util.EntitiesUtil;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;

import org.hibernate.Session;
import org.junit.Test;

public class AccountApp {

    @Test
    public void testOneToManyUnidirectional() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryAnnotation().openSession();
        session.beginTransaction();

        final Account account = EntitiesUtil.getAccount("Account");

        final Transaction transaction = EntitiesUtil.getTransaction("First transaction", "Type 1");
        final Transaction transaction1 = EntitiesUtil.getTransaction("Second transaction", "Type 2");

        account.getTransactions().add(transaction);
        account.getTransactions().add(transaction1);

        session.save(account);

        // Выполнится 3 INSERT
        // и 2 UPDATE
        //
        // insert into ACCOUNT (CLOSE_DATE, CREATED_BY, CREATED_DATE, CURRENT_BALANCE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME, OPEN_DATE, ACCOUNT_ID)
        //              values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        //
        // insert into TRANSACTION (TRANSACTION_ID, AMOUNT, CLOSING_BALANCE, CREATED_BY, CREATED_DATE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NOTES, TITLE, TRANSACTION_TYPE, ACCOUNT_ID)
        //             values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        //
        // insert into TRANSACTION (TRANSACTION_ID, AMOUNT, CLOSING_BALANCE, CREATED_BY, CREATED_DATE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NOTES, TITLE, TRANSACTION_TYPE, ACCOUNT_ID)
        //             values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        //
        // update TRANSACTION set ACCOUNT_ID=? where TRANSACTION_ID=?
        //
        // update TRANSACTION set ACCOUNT_ID=? where TRANSACTION_ID=?

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testOneToManyBidirectional() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final Account account = EntitiesUtil.getAccount("Account");

        final Transaction transaction = EntitiesUtil.getTransaction("First transaction", "Type 1");
        transaction.setAccount(account);

        final Transaction transaction1 = EntitiesUtil.getTransaction("Second transaction", "Type 2");
        transaction1.setAccount(account);

        account.getTransactions().add(transaction);
        account.getTransactions().add(transaction1);

        session.save(account);

        session.getTransaction().commit();

        final Transaction transaction2 = session.get(Transaction.class, account.getTransactions().get(0).getTransactionId());
        System.out.println(transaction2.getAccount().getName()); //Account

        session.close();
    }

    @Test
    public void testManyToManyUnidirectional() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryAnnotation().openSession();
        session.beginTransaction();

        final Account account = EntitiesUtil.getAccount("Account 1");
        final Account account1 = EntitiesUtil.getAccount("Account 2");

        final User user = EntitiesUtil.getUser("Oleh", "Linnyk");
        final User user1 = EntitiesUtil.getUser("Iryna", "Linnyk");

        account.getUsers().add(user);
        account.getUsers().add(user1);

        account1.getUsers().add(user);
        account1.getUsers().add(user1);

        session.save(account);
        session.save(account1);

        // Будет выполнено 8 запросов
        //
        // insert into ACCOUNT (ACCOUNT_ID, CLOSE_DATE, CREATED_BY, CREATED_DATE, CURRENT_BALANCE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME, OPEN_DATE) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into FINANCES_USER (USER_ADDRESS_LINE_1, USER_ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, BIRTH_DATE, CREATED_BY, CREATED_DATE, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, LAST_UPDATED_BY, LAST_UPDATED_DATE, USER_ID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into FINANCES_USER (USER_ADDRESS_LINE_1, USER_ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, BIRTH_DATE, CREATED_BY, CREATED_DATE, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, LAST_UPDATED_BY, LAST_UPDATED_DATE, USER_ID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into ACCOUNT (ACCOUNT_ID, CLOSE_DATE, CREATED_BY, CREATED_DATE, CURRENT_BALANCE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME, OPEN_DATE) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into USER_ACCOUNT (ACCOUNT_ID, USER_ID) values (?, ?)
        // insert into USER_ACCOUNT (ACCOUNT_ID, USER_ID) values (?, ?)
        // insert into USER_ACCOUNT (ACCOUNT_ID, USER_ID) values (?, ?)
        // insert into USER_ACCOUNT (ACCOUNT_ID, USER_ID) values (?, ?)

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testManyToManyBidirectional() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryAnnotation().openSession();
        session.beginTransaction();

        final Account account = EntitiesUtil.getAccount("Account 1");
        final Account account1 = EntitiesUtil.getAccount("Account 2");

        final User user = EntitiesUtil.getUser("Oleh", "Linnyk");
        final User user1 = EntitiesUtil.getUser("Iryna", "Linnyk");

        account.getUsers().add(user);
        account.getUsers().add(user1);

        user.getAccounts().add(account);
        user.getAccounts().add(account1);

        account1.getUsers().add(user);
        account1.getUsers().add(user1);

        user1.getAccounts().add(account);
        user1.getAccounts().add(account1);

        session.save(account);
        session.save(account1);

        // Будет выполнено 8 запросов
        //
        // insert into ACCOUNT (ACCOUNT_ID, CLOSE_DATE, CREATED_BY, CREATED_DATE, CURRENT_BALANCE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME, OPEN_DATE) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into FINANCES_USER (USER_ADDRESS_LINE_1, USER_ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, BIRTH_DATE, CREATED_BY, CREATED_DATE, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, LAST_UPDATED_BY, LAST_UPDATED_DATE, USER_ID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into ACCOUNT (ACCOUNT_ID, CLOSE_DATE, CREATED_BY, CREATED_DATE, CURRENT_BALANCE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME, OPEN_DATE) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into FINANCES_USER (USER_ADDRESS_LINE_1, USER_ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, BIRTH_DATE, CREATED_BY, CREATED_DATE, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, LAST_UPDATED_BY, LAST_UPDATED_DATE, USER_ID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into USER_ACCOUNT (ACCOUNT_ID, USER_ID) values (?, ?)
        // insert into USER_ACCOUNT (ACCOUNT_ID, USER_ID) values (?, ?)
        // insert into USER_ACCOUNT (ACCOUNT_ID, USER_ID) values (?, ?)
        // insert into USER_ACCOUNT (ACCOUNT_ID, USER_ID) values (?, ?)

        session.getTransaction().commit();
        session.close();
    }

}
