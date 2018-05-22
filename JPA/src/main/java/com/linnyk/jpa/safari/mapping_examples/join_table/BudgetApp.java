package com.linnyk.jpa.safari.mapping_examples.join_table;

import org.hibernate.Session;
import org.junit.Test;

import com.linnyk.jpa.safari.entities.Account;
import com.linnyk.jpa.safari.entities.association.Transaction;
import com.linnyk.jpa.safari.entities.join_table.Budget;
import com.linnyk.jpa.safari.util.EntitiesUtil;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;

public class BudgetApp {

    @Test
    public void testJoinTable() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryAnnotation().openSession();
        session.beginTransaction();

        final Account account = EntitiesUtil.getAccount("Account");

        final Budget budget = EntitiesUtil.getBudget();

        final Transaction transaction = EntitiesUtil.getTransaction("First transaction", "Type 1");
        transaction.setAccount(account);
        final Transaction transaction1 = EntitiesUtil.getTransaction("Second transaction", "Type 2");
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
