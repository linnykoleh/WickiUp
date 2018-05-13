package com.linnyk.jpa.safari.data;

import com.linnyk.jpa.safari.data.entities.User;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Date;

public class HibernateClient {

    @Test
    public void testAnnotation() {
        final Session session = HibernateUtil.getSessionFactoryAnnotation().openSession();
        session.beginTransaction();

        final User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh ANNOTATION 1");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testXML() {
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh XML 1");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}
