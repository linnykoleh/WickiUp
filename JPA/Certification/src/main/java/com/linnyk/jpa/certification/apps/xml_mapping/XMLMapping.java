package com.linnyk.jpa.certification.apps.xml_mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.certification.entities.xml_mapping.Employee;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class XMLMapping {

    /**
     * Take a look on mapping in resources/META-INF/xml_mapping/mappingEmployee.xml
     */
    @Test
    public void testEmployee(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        final Employee employee = new Employee("Oleh", 10000);

        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();
        // insert into Employee (name, salary, id) values (?, ?, ?)

        /**

         EMPLOYEE
         -----------------------
         | ID |  NAME | SALARY |
         -----------------------
         | 0  |  Oleh | 10000  |
         -----------------------

         */

    }

}
