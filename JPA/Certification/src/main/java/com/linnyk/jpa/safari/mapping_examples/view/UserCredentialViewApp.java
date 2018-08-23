package com.linnyk.jpa.safari.mapping_examples.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.linnyk.jpa.safari.entities.view.UserCredentialView;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class UserCredentialViewApp {

	@Test
	public void test_JPA(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Query query = entityManager.createNativeQuery("select * from V_USER_CREDENTIALS", UserCredentialView.class);
		final List<UserCredentialView> resultList = query.getResultList();

		for(UserCredentialView userCredentialView : resultList){
			System.out.println(userCredentialView);
		}
		//[UserCredentialView{userId=1, firstName='Test', lastName='test', username='Oleh', password='password'}]

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void test_Hibernate(){
		final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
		final Session session = sessionFactoryXML.openSession();
		final Transaction transaction = session.getTransaction();
		transaction.begin();

		final org.hibernate.query.Query query = session.createNativeQuery("select * from V_USER_CREDENTIALS", UserCredentialView.class);
		final List<UserCredentialView> resultList = query.getResultList();

		for(UserCredentialView userCredentialView : resultList){
			System.out.println(userCredentialView);
		}
		//[UserCredentialView{userId=1, firstName='Test', lastName='test', username='Oleh', password='password'}]

		transaction.commit();
		session.close();
		sessionFactoryXML.close();
	}
}
