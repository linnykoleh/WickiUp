package edu.jpa.service;

import edu.jpa.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 23.02.15
 */
public class CompanyService {
    private static EntityManagerFactory emf = null;
    static {
        emf = Persistence.createEntityManagerFactory("persistenceUnits.lab05");
        init ();
    }

    public Company getCompany(int id) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.find(Company.class, id);
        } finally {
            em.getTransaction().rollback();
        }
    }

    public void saveCompany(Company company) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(company);
        em.getTransaction().commit();
    }

    private static void init() {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Company company = new Company();
        company.setName("Microsoft");
        em.persist(company);

        em.getTransaction().commit();
    }
}
