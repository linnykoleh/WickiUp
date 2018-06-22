package com.linnyk.jpa.certification.apps.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.certification.entities.map.Employee;
import com.linnyk.jpa.certification.entities.map.Project;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class MapApp {

    @Test
    public void test(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        final Map<Project, Date> projectDateMap = new HashMap<>();
        projectDateMap.put(new Project(), new Date());
        projectDateMap.put(new Project(), new Date());
        projectDateMap.put(new Project(), new Date());

        final Employee employee = new Employee();
        employee.setCurrentProject(projectDateMap);

        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
