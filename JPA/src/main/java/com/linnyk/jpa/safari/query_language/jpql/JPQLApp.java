package com.linnyk.jpa.safari.query_language.jpql;

import com.linnyk.jpa.safari.entities.Account;
import com.linnyk.jpa.safari.entities.association.Transaction;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

public class JPQLApp {

    @Test
    public void test_Simple_Query(){
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


    @Test
    public void test_Expression_Operators(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        final TypedQuery<Transaction> queryTyped = entityManager.createQuery("from Transaction t "
                + " where (t.amount between 5 and 100) and t.title like '%s' "
                + " order by t.title", Transaction.class);
        final List<Transaction> resultTyped = queryTyped.getResultList();

        for(Transaction tran : resultTyped){
            System.out.println(tran.getTitle());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void test_Parameters(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

//        final TypedQuery<Transaction> queryTyped = entityManager.createQuery("from Transaction t "
//                + " where (t.amount between :amount1 and :amount2) and t.title like '%s' "
//                + " order by t.title", Transaction.class);
//        Можно использовать именование параметров как и в HQL

        final TypedQuery<Transaction> queryTyped = entityManager.createQuery("from Transaction t "
                + " where (t.amount between ?1 and ?2) and t.title like '%s' "
                + " order by t.title", Transaction.class);
        queryTyped.setParameter(1, new BigDecimal(25));
        queryTyped.setParameter(2, new BigDecimal(75));

        final List<Transaction> resultTyped = queryTyped.getResultList();

        for(Transaction tran : resultTyped){
            System.out.println(tran.getTitle());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void test_Joins(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        final TypedQuery<Account> queryTyped = entityManager.createQuery("select distinct a from Transaction t "
                + " join t.account a "
                + " where t.amount > 5 or t.transactionType = 'Deposit'",
                Account.class);

        final List<Account> resultList = queryTyped.getResultList();
        // select distinct account1_.ACCOUNT_ID as ACCOUNT_1_0_, account1_.ACCOUNT_TYPE as ACCOUNT_2_0_, account1_.CLOSE_DATE as CLOSE_DA3_0_, account1_.CREATED_BY as CREATED_4_0_, account1_.CREATED_DATE as CREATED_5_0_, account1_.CURRENT_BALANCE as CURRENT_6_0_, account1_.INITIAL_BALANCE as INITIAL_7_0_, account1_.LAST_UPDATED_BY as LAST_UPD8_0_, account1_.LAST_UPDATED_DATE as LAST_UPD9_0_, account1_.NAME as NAME10_0_, account1_.OPEN_DATE as OPEN_DA11_0_ from TRANSACTION transactio0_
        // inner join ACCOUNT account1_ on transactio0_.ACCOUNT_ID=account1_.ACCOUNT_ID
        // where transactio0_.AMOUNT>5 or transactio0_.TRANSACTION_TYPE='Deposit'

        for(Account account : resultList){
            System.out.println(account.getName());
        }
        // Account

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void test_Functions(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        final Query queryTyped = entityManager.createQuery("select distinct t.account.name, "
                        + " concat(concat(t.account.closeDate, '::'), t.account.initialBalance)"
                        + " from Transaction t "
                        + " join t.account a "
                        + " where t.amount > 5 or t.transactionType = 'Deposit'");

        final List<Object[]> resultList = queryTyped.getResultList();

        for(Object[] obj : resultList){
            System.out.println(obj[0]);
            System.out.println(obj[1]);
        }
//        Account
//        2018-05-24 08:33:31.585::10.00

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void test_Named_Query(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        final Query namedQuery = entityManager.createNamedQuery("Account.byWithdrawlAccount");
        namedQuery.setParameter("amount", new BigDecimal(5));

        final List<Object[]> resultList = namedQuery.getResultList();
        // select distinct account1_.NAME as col_0_0_, ((account1_.CLOSE_DATE||'::')||account1_.INITIAL_BALANCE) as col_1_0_ from TRANSACTION transactio0_
        // inner join ACCOUNT account1_ on transactio0_.ACCOUNT_ID=account1_.ACCOUNT_ID
        // where transactio0_.AMOUNT>? or transactio0_.TRANSACTION_TYPE='Deposit'

        for(Object[] obj: resultList){
            System.out.println(obj[0]);
            System.out.println(obj[1]);
        }
//        Account
//        2018-05-24 08:33:31.585::10.00

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
