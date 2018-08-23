package com.linnyk.jpa.certification.apps;

import com.linnyk.jpa.certification.entities.FieldPropertyName;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class FieldPropertyNameApp {

    @Test
    public void test(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        final FieldPropertyName fieldPropertyName =
                new FieldPropertyName("TestName");

        entityManager.persist(fieldPropertyName);
        //

        /**


         */

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
