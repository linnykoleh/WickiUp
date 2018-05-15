package com.linnyk.jpa.safari.data.apps.generation_type_app;

import java.util.Date;

import com.linnyk.jpa.safari.data.entities.generation_type.*;
import org.hibernate.Session;
import org.junit.Test;

import com.linnyk.jpa.safari.data.util.HibernateUtil;

public class GenerationTypeApp {

    @Test
    public void test_GenerationType_TABLE() {
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final UserGTTable user = new UserGTTable();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");

        session.save(user);

        session.getTransaction().commit();
        session.close();

        final Session session1 = HibernateUtil.getSessionFactoryXML().openSession();
        session1.beginTransaction();

        final UserGTTable userGTTable = session1.get(UserGTTable.class, user.getUserId());
        System.out.println(userGTTable); // UserGTTable{userId=1, firstName='Oleh', lastName='Linnyk', birthDate=2018-05-14 17:02:27.787,
                                         // emailAddress='Oleh@Linnyk.com', lastUpdatedDate=2018-05-14 17:02:27.787, lastUpdatedBy='Oleh',
                                         // createdDate=2018-05-14 17:02:27.787, createdBy='Oleh'}


        session1.getTransaction().commit();
        session1.close();
    }

    @Test
    public void test_GenerationType_SEQUENCE() {
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final UserGTSequence user = new UserGTSequence();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");

        session.save(user); // userId=-23

        session.getTransaction().commit();
        session.close();
        System.out.println(user); // UserGTSequence{userId=1, firstName='Oleh', lastName='Linnyk', birthDate=Mon May 14 17:02:59 CEST 2018,
                                  // emailAddress='Oleh@Linnyk.com', lastUpdatedDate=Mon May 14 17:02:59 CEST 2018, lastUpdatedBy='Oleh',
                                  // createdDate=Mon May 14 17:02:59 CEST 2018, createdBy='Oleh'}

        final Session session1 = HibernateUtil.getSessionFactoryXML().openSession();
        session1.beginTransaction();

        final UserGTSequence user1 = new UserGTSequence();
        user1.setBirthDate(new Date());
        user1.setCreatedDate(new Date());
        user1.setCreatedBy("Oleh");
        user1.setEmailAddress("Oleh@Linnyk.com");
        user1.setFirstName("Oleh");
        user1.setLastName("Linnyk");
        user1.setLastUpdatedDate(new Date());
        user1.setLastUpdatedBy("Oleh");

        session1.save(user1); // UserGTSequence{userId=2, firstName='Oleh', lastName='Linnyk', birthDate=Mon May 14 17:02:59 CEST 2018,
                              // emailAddress='Oleh@Linnyk.com', lastUpdatedDate=Mon May 14 17:02:59 CEST 2018, lastUpdatedBy='Oleh',
                              // createdDate=Mon May 14 17:02:59 CEST 2018, createdBy='Oleh'}

        session1.getTransaction().commit();
        session1.close();
        System.out.println(user1);
    }

    @Test
    public void test_GenerationType_IDENTITY() {
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final UserGTIdentity user = new UserGTIdentity();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");

        session.save(user);

        session.getTransaction().commit();
        session.close();
        System.out.println(user); // UserGTIdentity{userId=10, firstName='Oleh', lastName='Linnyk', birthDate=Mon May 14 20:46:48 EEST 2018,
                                  // emailAddress='Oleh@Linnyk.com', lastUpdatedDate=Mon May 14 20:46:48 EEST 2018, lastUpdatedBy='Oleh',
                                  // createdDate=Mon May 14 20:46:48 EEST 2018, createdBy='Oleh'}

    }

    @Test
    public void test_GenerationType_AUTO() {
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final UserGTAuto user = new UserGTAuto();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");

        session.save(user);

        session.getTransaction().commit();
        session.close();
        System.out.println(user); // UserGTAuto{userId=1, firstName='Oleh', lastName='Linnyk', birthDate=Mon May 14 17:16:55 CEST 2018,
                                  // emailAddress='Oleh@Linnyk.com', lastUpdatedDate=Mon May 14 17:16:55 CEST 2018, lastUpdatedBy='Oleh',
                                  // createdDate=Mon May 14 17:16:55 CEST 2018, createdBy='Oleh'}
    }

    @Test
    public void test_NO_GenerationType() {
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final UserNoGT user = new UserNoGT();
        user.setBirthDate(new Date());
//        user.setUserId(134L); To fix the problem add id manually
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");

        session.save(user); // If we don't have GenerationType then error org.hibernate.id.IdentifierGenerationException:
                            // ids for this class must be manually assigned beforeQuery calling save()
        session.getTransaction().commit();
        session.close();
        System.out.println(user);
    }

}
