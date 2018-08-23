package com.linnyk.jpa.certification.apps.map_extended.map_key;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.certification.entities.map_extended.map_key.Department;
import com.linnyk.jpa.certification.entities.map_extended.map_key.Employee;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class MapApp {

    @Test
    public void mapKey(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        final Employee employee1 = new Employee("JOHN");
        final Employee employee2 = new Employee("MARK");
        final Employee employee3 = new Employee("ALAN");

        final Department department = new Department();
        department.getEmployees().put(1, employee1);
        department.getEmployees().put(2, employee2);
        department.getEmployees().put(3, employee3);

        employee1.setDepartment(department);
        employee2.setDepartment(department);
        employee3.setDepartment(department);

        entityManager.persist(department);

        transaction.commit();

//      insert into DEPARTMENT_MK (DEPARTMENT_NAME, id) values (?, ?)
//
//      insert into EMPLOYEE_MK (department_id, EMPLOYEE_NAME, EMPLOYEE_ID) values (?, ?, ?)
//      insert into EMPLOYEE_MK (department_id, EMPLOYEE_NAME, EMPLOYEE_ID) values (?, ?, ?)
//      insert into EMPLOYEE_MK (department_id, EMPLOYEE_NAME, EMPLOYEE_ID) values (?, ?, ?)

        entityManager.close();
        entityManagerFactory.close();
    }

}
