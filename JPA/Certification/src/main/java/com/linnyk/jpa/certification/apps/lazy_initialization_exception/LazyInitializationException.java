package com.linnyk.jpa.certification.apps.lazy_initialization_exception;

import com.linnyk.jpa.certification.entities.lazy_initialization_exception.Comment;
import com.linnyk.jpa.certification.entities.lazy_initialization_exception.User;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Arrays;

public class LazyInitializationException {

    @Test
    public void test(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        final Comment comment1 = new Comment("Title1", "Value1");
        final Comment comment2 = new Comment("Title2", "Value2");
        final Comment comment3 = new Comment("Title3", "Value3");

        final User user = new User("Username");
        user.setComments(Arrays.asList(comment1, comment2, comment3));

        comment1.setUser(user);
        comment2.setUser(user);
        comment3.setUser(user);

        entityManager.persist(user);

        transaction.commit();
        entityManager.close();

        /** NEW SESSION */

        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        EntityTransaction transaction1 = entityManager1.getTransaction();
        transaction1.begin();

        final User userDB = entityManager1.find(User.class, 1L);

        transaction1.commit();
        entityManager1.close();
        entityManagerFactory.close();

        /** OUT OF SESSION */
        System.out.println(userDB.getComments().get(0).getTitle());
//        org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role:
//         com.linnyk.jpa.certification.entities.lazy_initialization_exception.User.comments, could not initialize proxy - no Session

    }

}
