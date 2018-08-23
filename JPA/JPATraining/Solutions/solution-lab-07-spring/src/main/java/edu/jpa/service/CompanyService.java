package edu.jpa.service;

import edu.jpa.entity.Company;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 23.02.15
 */
@Repository
public class CompanyService {

    @PersistenceContext
    private EntityManager em;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void init() {
        String[] companies = {"Microsoft", "IBM"};
        for (String name : companies) {
            Company company = new Company();
            company.setName(name);
            em.persist(company);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Company getCompany(int id) {
        return em.find(Company.class, id);
    }
}
