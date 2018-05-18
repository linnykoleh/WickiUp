package com.linnyk.jpa.safari.data.apps.association;

import com.linnyk.jpa.safari.data.entities.association.Account;
import com.linnyk.jpa.safari.data.entities.association.Transaction;
import com.linnyk.jpa.safari.data.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class AccountApp {

    @Test
    public void testOneToManyUnidirectional() {
        final Session session = HibernateUtil.getSessionFactoryAnnotation().openSession();
        session.beginTransaction();

        final Account account = getAccount();

        final Transaction transaction = getTransaction("First transaction", "Type 1");
        final Transaction transaction1 = getTransaction("Second transaction", "Type 2");

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
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final Account account = getAccount();

        final Transaction transaction = getTransaction("First transaction", "Type 1");
        transaction.setAccount(account);

        final Transaction transaction1 = getTransaction("Second transaction", "Type 2");
        transaction1.setAccount(account);

        account.getTransactions().add(transaction);
        account.getTransactions().add(transaction1);

        session.save(account);

        session.getTransaction().commit();

        final Transaction transaction2 = session.get(Transaction.class, account.getTransactions().get(0).getTransactionId());
        System.out.println(transaction2.getAccount().getName()); //Account

        session.close();
    }

    private Account getAccount() {
        final Account account = new Account();

        account.setName("Account");
        account.setInitialBalance(BigDecimal.TEN);
        account.setCurrentBalance(BigDecimal.ONE);
        account.setOpenDate(new Date());
        account.setCloseDate(new Date());
        account.setCreatedBy("Oleh");
        account.setCreatedDate(new Date());
        account.setLastUpdatedBy("Oleh");
        account.setLastUpdatedDate(new Date());

        return account;
    }

    private Transaction getTransaction(String title, String tt) {
        final Transaction transaction = new Transaction();

        transaction.setTitle(title);
        transaction.setTransactionType(tt);
        transaction.setAmount(BigDecimal.TEN);
        transaction.setInitialBalance(BigDecimal.TEN);
        transaction.setCreatedBy("Oleh");
        transaction.setCreatedDate(new Date());
        transaction.setLastUpdatedBy("Oleh");
        transaction.setLastUpdatedDate(new Date());
        transaction.setClosingBalance(BigDecimal.ONE);

        return transaction;
    }
}
