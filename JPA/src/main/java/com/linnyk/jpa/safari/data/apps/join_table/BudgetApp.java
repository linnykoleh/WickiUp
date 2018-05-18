package com.linnyk.jpa.safari.data.apps.join_table;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import com.linnyk.jpa.safari.data.entities.association.Account;
import com.linnyk.jpa.safari.data.entities.association.Transaction;
import com.linnyk.jpa.safari.data.entities.join_table.Budget;
import com.linnyk.jpa.safari.data.util.HibernateUtil;

public class BudgetApp {

    @Test
    public void testJoinTable() {
        final Session session = HibernateUtil.getSessionFactoryAnnotation().openSession();
        session.beginTransaction();

        final Account account = getAccount();

        final Budget budget = new Budget();
        budget.setGoalAmount(BigDecimal.TEN);
        budget.setName("Emergency Fund");
        budget.setPeriod("Yearly");

        final Transaction transaction = getTransaction("First transaction", "Type 1");
        transaction.setAccount(account);
        final Transaction transaction1 = getTransaction("Second transaction", "Type 2");
        transaction1.setAccount(account);

        budget.getTransactions().add(transaction);
        budget.getTransactions().add(transaction1);

        session.save(budget);

        // insert into BUDGET (GOAL_AMOUNT, NAME, PERIOD, BUDGET_ID) values (?, ?, ?, ?)
        // insert into ACCOUNT (ACCOUNT_ID, CLOSE_DATE, CREATED_BY, CREATED_DATE, CURRENT_BALANCE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NAME, OPEN_DATE) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into TRANSACTION (TRANSACTION_ID, ACCOUNT_ID, AMOUNT, CLOSING_BALANCE, CREATED_BY, CREATED_DATE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NOTES, TITLE, TRANSACTION_TYPE) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into TRANSACTION (TRANSACTION_ID, ACCOUNT_ID, AMOUNT, CLOSING_BALANCE, CREATED_BY, CREATED_DATE, INITIAL_BALANCE, LAST_UPDATED_BY, LAST_UPDATED_DATE, NOTES, TITLE, TRANSACTION_TYPE) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into BUDGET_TRANSACTION (BUDGET_ID, TRANSACTION_ID) values (?, ?)
        // insert into BUDGET_TRANSACTION (BUDGET_ID, TRANSACTION_ID) values (?, ?)

        session.getTransaction().commit();
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
