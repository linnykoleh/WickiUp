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
        emf = null; // create EntityManagerFactory instance here
        init();
    }

    public Company getCompany(int id) {
        return null;
    }

    public void saveCompany(Company company) {
    }

    private static void init() {
    }
}
