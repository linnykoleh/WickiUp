package com.linnyk.jpa.safari.criteria.jpql;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.junit.Test;

import com.linnyk.jpa.safari.entities.association.Transaction;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class JPQLApp {

    @Test
    public void test_Simple_Selection(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        // select t from Transaction t
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Transaction> query = criteriaBuilder.createQuery(Transaction.class);

        final Root root = query.from(Transaction.class);
        query.select(root);

        final TypedQuery<Transaction> typedQuery = entityManager.createQuery(query);
        final List<Transaction> resultList = typedQuery.getResultList();

        for(Transaction tran : resultList){
            System.out.println(tran.getTitle());
        }
        //First transaction
        //Second transaction
        //First transaction
        //Second transaction

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void test_Restriction(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        // select transactio0_.TRANSACTION_ID as TRANSACT1_22_, transactio0_.ACCOUNT_ID as ACCOUNT12_22_, transactio0_.AMOUNT as AMOUNT2_22_, transactio0_.CLOSING_BALANCE as CLOSING_3_22_, transactio0_.CREATED_BY as CREATED_4_22_, transactio0_.CREATED_DATE as CREATED_5_22_, transactio0_.INITIAL_BALANCE as INITIAL_6_22_, transactio0_.LAST_UPDATED_BY as LAST_UPD7_22_, transactio0_.LAST_UPDATED_DATE as LAST_UPD8_22_, transactio0_.NOTES as NOTES9_22_, transactio0_.TITLE as TITLE10_22_, transactio0_.TRANSACTION_TYPE as TRANSAC11_22_
        // from TRANSACTION transactio0_
        // where transactio0_.AMOUNT<=20 and transactio0_.TRANSACTION_TYPE=?
        // order by transactio0_.TITLE asc
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Transaction> query = criteriaBuilder.createQuery(Transaction.class);

        final Root root = query.from(Transaction.class);

        final Path<BigDecimal> amount = root.get("amount");
        final Path<String> transactionType = root.get("transactionType");
        final Path<String> title = root.get("title");

        query.select(root).where(criteriaBuilder.and(
                        criteriaBuilder.le(amount, new BigDecimal(20)),
                        criteriaBuilder.equal(transactionType, "Type 1")
                ))
                .orderBy(criteriaBuilder.asc(title));

        final TypedQuery<Transaction> typedQuery = entityManager.createQuery(query);
        final List<Transaction> resultList = typedQuery.getResultList();

        for(Transaction tran : resultList){
            System.out.println(tran.getTitle());
        }
        //First transaction
        //First transaction

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void test_Paging(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        // select transactio0_.TRANSACTION_ID as TRANSACT1_22_, transactio0_.ACCOUNT_ID as ACCOUNT12_22_, transactio0_.AMOUNT as AMOUNT2_22_, transactio0_.CLOSING_BALANCE as CLOSING_3_22_, transactio0_.CREATED_BY as CREATED_4_22_, transactio0_.CREATED_DATE as CREATED_5_22_, transactio0_.INITIAL_BALANCE as INITIAL_6_22_, transactio0_.LAST_UPDATED_BY as LAST_UPD7_22_, transactio0_.LAST_UPDATED_DATE as LAST_UPD8_22_, transactio0_.NOTES as NOTES9_22_, transactio0_.TITLE as TITLE10_22_, transactio0_.TRANSACTION_TYPE as TRANSAC11_22_
        // from TRANSACTION transactio0_
        // limit ?
        // offset ?
        // where account0_.ACCOUNT_ID=?
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Transaction> query = criteriaBuilder.createQuery(Transaction.class);

        final Root root = query.from(Transaction.class);
        query.select(root);

        final TypedQuery<Transaction> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(1);
        typedQuery.setMaxResults(3);
        final List<Transaction> resultList = typedQuery.getResultList();

        for(Transaction tran : resultList){
            System.out.println(tran.getTitle());
        }
        //Second transaction
        //First transaction
        //Second transaction

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
