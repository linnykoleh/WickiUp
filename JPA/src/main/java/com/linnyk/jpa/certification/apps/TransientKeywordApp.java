package com.linnyk.jpa.certification.apps;

import com.linnyk.jpa.certification.entities.TransientKeyword;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class TransientKeywordApp {

    @Test
    public void test(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        final TransientKeyword transientKeyword =
                new TransientKeyword("TestName", "TestValueOld", "TestValueNew");

        entityManager.persist(transientKeyword);
        //insert into TransientKeyword (name, id) values (?, ?)

        /**

         There are no transient and @Transient fields

         TRANSIENT_KEYWORD
         -----------------
         | id | name     |
         -----------------
         | 1  |	TestName |
         -----------------

         */

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }


}
