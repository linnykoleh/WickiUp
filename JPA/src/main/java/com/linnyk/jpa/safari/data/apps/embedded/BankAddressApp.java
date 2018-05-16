package com.linnyk.jpa.safari.data.apps.embedded;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import com.linnyk.jpa.safari.data.entities.embedded.Bank;
import com.linnyk.jpa.safari.data.util.HibernateUtil;

public class BankAddressApp {

    @Test
    public void testEmbeddable() {
        final Session session = HibernateUtil.getSessionFactoryAnnotation().openSession();

        try {
            session.beginTransaction();

           final Bank bank = new Bank();
            bank.setName("Federal Trust");
            bank.setAddressLine1("33 Wall Street");
            bank.setAddressLine2("Suite 2");
            bank.setCity("New York");
            bank.setState("NY");
            bank.setZipCode("27914");
            bank.setCreatedBy("Kevin Bowersox");
            bank.setCreatedDate(new Date());
            bank.setLastUpdatedBy("Kevin Bowersox");
            bank.setLastUpdatedDate(new Date());
            bank.setInternational(false);

            session.save(bank);

        }finally {
            session.getTransaction().commit();
            session.close();
        }

    }

}
