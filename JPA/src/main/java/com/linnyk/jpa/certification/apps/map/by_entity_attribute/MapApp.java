package com.linnyk.jpa.certification.apps.map.by_entity_attribute;

import com.linnyk.jpa.certification.entities.map.by_entity_attribute.Department;
import com.linnyk.jpa.certification.entities.map.by_entity_attribute.Employee;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class MapApp {

    @Test
    public void test(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        final Employee employee1 = new Employee("JOHN");
        final Employee employee2 = new Employee("MARK");
        final Employee employee3 = new Employee("ALAN");

        final Department department = new Department();
        department.getEmployees().put(employee1.getId(), employee1);
        department.getEmployees().put(employee2.getId(), employee2);
        department.getEmployees().put(employee3.getId(), employee3);

        employee1.setDepartment(department);
        employee2.setDepartment(department);
        employee3.setDepartment(department);

        entityManager.persist(department);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
