package com.linnyk.jpa.safari.query_language.jpql;

import com.linnyk.jpa.safari.entities.association.Transaction;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class JPQLApp {

    @Test
    public void test(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        final Query query = entityManager.createQuery("from Transaction");
        final List<Transaction> resultList = query.getResultList();

        for(Transaction tran : resultList){
            System.out.println(tran);
        }
        // select account0_.ACCOUNT_ID as ACCOUNT_1_0_0_, account0_.ACCOUNT_TYPE as ACCOUNT_2_0_0_, account0_.CLOSE_DATE as CLOSE_DA3_0_0_, account0_.CREATED_BY as CREATED_4_0_0_, account0_.CREATED_DATE as CREATED_5_0_0_, account0_.CURRENT_BALANCE as CURRENT_6_0_0_, account0_.INITIAL_BALANCE as INITIAL_7_0_0_, account0_.LAST_UPDATED_BY as LAST_UPD8_0_0_, account0_.LAST_UPDATED_DATE as LAST_UPD9_0_0_, account0_.NAME as NAME10_0_0_, account0_.OPEN_DATE as OPEN_DA11_0_0_ from ACCOUNT account0_ where account0_.ACCOUNT_ID=?
        // Transaction{transactionId=1, transactionType='Type 1', title='First transaction', amount=10.00, account=com.linnyk.jpa.safari.entities.Account@1698d7c0, initialBalance=10.00, closingBalance=1.00, notes='null', lastUpdatedDate=2018-05-23 22:00:32.13, lastUpdatedBy='Oleh', createdDate=2018-05-23 22:00:32.13, createdBy='Oleh'}
        // Transaction{transactionId=2, transactionType='Type 2', title='Second transaction', amount=10.00, account=com.linnyk.jpa.safari.entities.Account@1698d7c0, initialBalance=10.00, closingBalance=1.00, notes='null', lastUpdatedDate=2018-05-23 22:00:32.13, lastUpdatedBy='Oleh', createdDate=2018-05-23 22:00:32.13, createdBy='Oleh'}

        final TypedQuery<Transaction> queryTyped = entityManager.createQuery("from Transaction", Transaction.class);
        final List<Transaction> resultTyped = queryTyped.getResultList();

        for(Transaction tran : resultTyped){
            System.out.println(tran);
        }
        // select account0_.ACCOUNT_ID as ACCOUNT_1_0_0_, account0_.ACCOUNT_TYPE as ACCOUNT_2_0_0_, account0_.CLOSE_DATE as CLOSE_DA3_0_0_, account0_.CREATED_BY as CREATED_4_0_0_, account0_.CREATED_DATE as CREATED_5_0_0_, account0_.CURRENT_BALANCE as CURRENT_6_0_0_, account0_.INITIAL_BALANCE as INITIAL_7_0_0_, account0_.LAST_UPDATED_BY as LAST_UPD8_0_0_, account0_.LAST_UPDATED_DATE as LAST_UPD9_0_0_, account0_.NAME as NAME10_0_0_, account0_.OPEN_DATE as OPEN_DA11_0_0_ from ACCOUNT account0_ where account0_.ACCOUNT_ID=?
        // Transaction{transactionId=1, transactionType='Type 1', title='First transaction', amount=10.00, account=com.linnyk.jpa.safari.entities.Account@1698d7c0, initialBalance=10.00, closingBalance=1.00, notes='null', lastUpdatedDate=2018-05-23 22:00:32.13, lastUpdatedBy='Oleh', createdDate=2018-05-23 22:00:32.13, createdBy='Oleh'}
        // Transaction{transactionId=2, transactionType='Type 2', title='Second transaction', amount=10.00, account=com.linnyk.jpa.safari.entities.Account@1698d7c0, initialBalance=10.00, closingBalance=1.00, notes='null', lastUpdatedDate=2018-05-23 22:00:32.13, lastUpdatedBy='Oleh', createdDate=2018-05-23 22:00:32.13, createdBy='Oleh'}


        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
