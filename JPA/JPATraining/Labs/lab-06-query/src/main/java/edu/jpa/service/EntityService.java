package edu.jpa.service;

import edu.jpa.entity.Company;
import edu.jpa.entity.Department;
import edu.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 23.02.15
 */
public abstract class EntityService {
    private final EntityManagerFactory emf;

    /**
     * Class constructor.
     * Contains logic for creating EntityManagerFactory instance and initializing the entities.
     */
    protected EntityService() {
        emf = Persistence.createEntityManagerFactory("persistenceUnits.lab06");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        /** Company */
        Company company = new Company();
        company.setName("Luxoft");
        em.persist(company);

        /** Department: Training Center */
        Department department = new Department();
        department.setName("Training Center");
        department.setCompany(company);
        em.persist(department);

        Employee employee = new Employee();
        employee.setName("Viktor");
        employee.setDepartment(department);
        em.persist(employee);

        employee = new Employee();
        employee.setName("Ivan");
        employee.setDepartment(department);
        em.persist(employee);

        /** Department: IT */
        department = new Department();
        department.setName("IT");
        department.setCompany(company);
        em.persist(department);

        employee = new Employee();
        employee.setName("Maxim");
        employee.setDepartment(department);
        em.persist(employee);

        employee = new Employee();
        employee.setName("Andrey");
        employee.setDepartment(department);
        em.persist(employee);

        employee = new Employee();
        employee.setName("Sergey");
        employee.setDepartment(department);
        em.persist(employee);

        /** */
        em.getTransaction().commit();
    }

    /**
     * Returns the configured instane of EntityManagerFactory
     *
     * @return configured instane of EntityManagerFactory
     */
    protected final EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    /**
     * Finds all existing employees that belong to department with given name.
     *
     * @param name - name of department to search
     * @return list of Employee entities
     */
    public abstract List<Employee> getEmployeesByDepartmentName(String name);

    /**
     * Returns statistics about existing Department entities in form of DepartmentInfo.
     *
     * @return list of DepartmentInfo objects
     */
    public abstract List<DepartmentInfo> getDepartmentsInfo();
}
