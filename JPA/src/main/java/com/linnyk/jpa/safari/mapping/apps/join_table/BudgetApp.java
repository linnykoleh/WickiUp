package com.linnyk.jpa.safari.mapping.apps.join_table;

import org.hibernate.Session;
import org.junit.Test;

import com.linnyk.jpa.safari.mapping.entities.association.Account;
import com.linnyk.jpa.safari.mapping.entities.association.Transaction;
import com.linnyk.jpa.safari.mapping.entities.join_table.Budget;
import com.linnyk.jpa.safari.mapping.util.EntityUtil;
import com.linnyk.jpa.safari.mapping.util.HibernateFactoryCreator;

public class BudgetApp {

    @Test
    public void testJoinTable() {
        final Session session = HibernateFactoryCreator.getSessionFactoryAnnotation().openSession();
        session.beginTransaction();

        final Account account = EntityUtil.getAccount("Account");

        final Budget budget = EntityUtil.getBudget();

        final Transaction transaction = EntityUtil.getTransaction("First transaction", "Type 1");
        transaction.setAccount(account);
        final Transaction transaction1 = EntityUtil.getTransaction("Second transaction", "Type 2");
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



}
