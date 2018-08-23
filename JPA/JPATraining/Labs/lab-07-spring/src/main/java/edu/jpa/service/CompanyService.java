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
public class CompanyService {
    public void init() {
    }

    public Company getCompany(int id) {
        return null;
    }
}
