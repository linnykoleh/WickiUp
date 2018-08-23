package edu.jpa;

import edu.jpa.entity.Company;
import edu.jpa.entity.Department;
import edu.jpa.entity.Employee;
import edu.jpa.entity.embeddables.Project;
import org.apache.log4j.PropertyConfigurator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.02.15
 */
public class Launcher {
    static {
        PropertyConfigurator.configure(Launcher.class.getResource("/log4j.properties"));
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnits.lab03");
        init(emf.createEntityManager());
        sampleCompany(emf.createEntityManager());
        sampleDepartment(emf.createEntityManager());
        sampleEmployee(emf.createEntityManager());
    }


    private static void init(EntityManager em) {
        em.getTransaction().begin();

        Company company = new Company();
        company.setId(1);
        company.setName("Company #1");
        em.persist(company);

        Department department = new Department();
        department.setId(1);
        department.setName("Department #1");
        department.setCompany(company);
        em.persist(department);

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Employee #1");
        employee.setDepartment(department);
        employee.setProjects(new ArrayList<Project>());

        Project project = new Project();
        project.setName("Project #1");
        employee.getProjects().add(project);

        project = new Project();
        project.setName("Project #2");
        employee.getProjects().add(project);
        em.persist(employee);

        department = new Department();
        department.setId(2);
        department.setName("Department #2");
        department.setCompany(company);
        em.persist(department);

        em.getTransaction().commit();
    }


    private static void sampleCompany(EntityManager em) {
        em.getTransaction().begin();

        Company company = em.find(Company.class, 1);
        println("Company.Name = [" + company.getName() + "]");

        for (int i = 0; i < company.getDepartments().size(); i++) {
            Department department = company.getDepartments().get(i);
            println("Company.Department[" + i + "].Name = [" + department.getName() + "]");
        }

        em.getTransaction().rollback();
    }


    private static void sampleDepartment(EntityManager em) {
        em.getTransaction().begin();

        Department department = em.find(Department.class, 1);
        println("Department.Company.Name = [" + department.getCompany().getName() + "]");
        println("Department.Name = [" + department.getName() + "]");

        em.getTransaction().rollback();
    }


    private static void sampleEmployee(EntityManager em) {
        em.getTransaction().begin();

        Employee employee = em.find(Employee.class, 1);
        println("Employee.Department.Name = [" + employee.getDepartment().getName() + "]");
        println("Employee.Name = [" + employee.getName() + "]");

        for (int i = 0; i < employee.getProjects().size(); i++) {
            Project project = employee.getProjects().get(i);
            println("Employee.Project[" + i + "].Name = [" + project.getName() + "]");
        }

        em.getTransaction().rollback();
    }


    private static void println(String s) {
        System.out.println("[==CONSOLE==] " + s);
    }
}
