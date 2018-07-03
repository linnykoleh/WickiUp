package com.linnyk.jpa.certification.apps.optimistic;

import javax.persistence.EntityManagerFactory;

import org.junit.Test;

import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class OptimisticApp {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();


	}
}
