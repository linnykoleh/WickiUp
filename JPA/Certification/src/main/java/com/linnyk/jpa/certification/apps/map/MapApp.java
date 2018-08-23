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

        final Project project1 = new Project();
        final Project project2 = new Project();
        final Project project3 = new Project();

        final Employee employee = new Employee();
        employee.getCurrentProject().put(project1, new Date());
        employee.getCurrentProject().put(project2, new Date());
        employee.getCurrentProject().put(project3, new Date());

        entityManager.persist(project1);
        entityManager.persist(project2);
        entityManager.persist(project3);

        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

        /**


         EMPLOYEE_CTM      EMP_PROJECTS                                         PROJECT_CTM
         ---------------   -------------------------------------------------    --------------
         | EMPLOYEE_ID |   |EMPLOYEE_ID | STARTDATE           | PROJECT_ID |    | PROJECT_ID |
         ---------------   -------------------------------------------------    --------------
         | 4           |-->|4	        | 2018-06-23 19:46:11 | 1          |--->| 1          |
         ---------------   |4	        | 2018-06-23 19:46:12 | 2          |    | 2          |
                           |4	        | 2018-06-23 19:46:13 | 3          |    | 3          |
                           -------------------------------------------------    --------------
         */
    }

}
