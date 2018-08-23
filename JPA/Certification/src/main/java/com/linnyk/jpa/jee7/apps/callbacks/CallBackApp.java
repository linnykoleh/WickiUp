package com.linnyk.jpa.jee7.apps.callbacks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.callbacks.CallBack;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class CallBackApp {

	@Test
	public void test() {
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		final CallBack callBack = new CallBack("CallBack name");
		entityManager.persist(callBack);
		// @PrePersist
		transaction.commit();
		// insert into CallBack (name, id) values (?, ?)
		// @PostPersist

		entityManager.close();

		//------------------
		final EntityManager entityManager1 = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction1 = entityManager1.getTransaction();
		transaction1.begin();

		final CallBack callBack1 = entityManager1.find(CallBack.class, 1L);
		// select callback0_.id as id1_20_0_, callback0_.name as name2_20_0_ from CallBack callback0_ where callback0_.id=?
		// @PostLoad

		callBack1.setName("CallBack name #2");
		transaction1.commit();
		// @PreUpdate
		// update CallBack set name=? where id=?
		// @PostUpdate

		transaction1.begin();
		entityManager1.remove(callBack1);
		// @PreRemove
		transaction1.commit();
		// delete from CallBack where id=?
		// @PostRemove

		entityManager1.close();
		entityManagerFactory.close();

	}

}
