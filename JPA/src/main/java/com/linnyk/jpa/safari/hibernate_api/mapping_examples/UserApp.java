package com.linnyk.jpa.safari.hibernate_api.mapping_examples;

import com.linnyk.jpa.safari.entities.User;
import com.linnyk.jpa.safari.entities.embedded.Address;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;

import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserApp {

    @Test
    public void testAnnotation() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryAnnotation().openSession();
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
        final Session session = HibernateFactoryBuilder.getSessionFactoryXML().openSession();
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

    @Test
    public void testUpdateNotUpdatable() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryXML().openSession();
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

        session.beginTransaction();
        final User user1 = session.get(User.class, user.getUserId());
        user.setFirstName("Oleh New");

        session.update(user1);
        /*
            update
                FINANCES_USER
            set
                BIRTH_DATE=?,
                EMAIL_ADDRESS=?,
                FIRST_NAME=?,
                LAST_NAME=?,
                LAST_UPDATED_BY=?,
                LAST_UPDATED_DATE=?
            where
                USER_ID=?
         */
        session.getTransaction().commit();

        session.close();
    }

    @Test
    public void testTransient() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryXML().openSession();
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
        user.setValid(true);

        session.save(user); // insert
                            // into
                            //    FINANCES_USER
                            //    (USER_ID, BIRTH_DATE, CREATED_BY, CREATED_DATE, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, LAST_UPDATED_BY, LAST_UPDATED_DATE)
                            // values
                            //    (null, ?, ?, ?, ?, ?, ?, ?, ?)
                            // There is no VALID field
        session.getTransaction().commit();

        session.close();
    }

    @Test
    public void testFormula() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final User user = new User();
        user.setBirthDate(java.sql.Date.valueOf(LocalDate.of(1993, Month.MAY, 07)));
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh XML 1");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");
        user.setValid(true);

        session.save(user);
        session.getTransaction().commit();

        session.refresh(user);

        session.close();

        System.out.println("My age is: " + user.getAge()); // My age is: 25
    }

    @Test
    public void testEmbedded() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final User user = new User();
        user.setBirthDate(java.sql.Date.valueOf(LocalDate.of(1993, Month.MAY, 07)));
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh XML 1");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");
        user.setValid(true);
        user.setAddressLine1("33 Wall Street");
        user.setAddressLine2("Suite 2");
        user.setCity("New York");
        user.setState("NY");
        user.setZipCode("27914");

        session.save(user);
        session.getTransaction().commit();

        session.refresh(user);

        session.close();

        System.out.println(user);  // User{userId=2, firstName='Oleh', lastName='Linnyk', birthDate=1993-05-07 00:00:00.0, emailAddress='Oleh@Linnyk.com',
                                   // address=Address{addressLine1='33 Wall Street', addressLine2='Suite 2', city='New York', state='NY', zipCode='27914'},
                                   // lastUpdatedDate=2018-05-16 13:59:14.483, lastUpdatedBy='Oleh', createdDate=2018-05-16 13:59:14.483, createdBy='Oleh XML 1',
                                   // valid=true, age=25}

    }

    @Test
    public void testCollectionObjects() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final User user = new User();
        user.setBirthDate(java.sql.Date.valueOf(LocalDate.of(1993, Month.MAY, 07)));
        user.setCreatedDate(new Date());
        user.setCreatedBy("Oleh XML 1");
        user.setEmailAddress("Oleh@Linnyk.com");
        user.setFirstName("Oleh");
        user.setLastName("Linnyk");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Oleh");
        user.setValid(true);
        user.setAddressLine1("33 Wall Street");
        user.setAddressLine2("Suite 2");
        user.setCity("New York");
        user.setState("NY");
        user.setZipCode("27914");

        final Address address1 = new Address();
        address1.setAddressLine1("4 Wall Street");
        address1.setAddressLine2("Suite 3");
        address1.setCity("NEW New York");
        address1.setState("NY");
        address1.setZipCode("12714");
        final Address address2 = new Address();
        address2.setAddressLine1("5 Wall Street");
        address2.setAddressLine2("Suite 4");
        address2.setCity("NEW 1 New York");
        address2.setState("NY");
        address2.setZipCode("22914");

        final List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);

        user.setAddresses(addresses);

        session.save(user);
        session.getTransaction().commit();

        session.close();

        //insert
        //    into
        //        FINANCES_USER
        //        (BIRTH_DATE, CREATED_BY, CREATED_DATE, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, LAST_UPDATED_BY, LAST_UPDATED_DATE, USER_ID)
        //    values
        //        (?, ?, ?, ?, ?, ?, ?, ?, ?)
        //
        // insert
        //    into
        //        USER_ADDRESS
        //        (USER_ID, USER_ADDRESS_LINE_1, USER_ADDRESS_LINE_2, CITY, STATE, ZIP_CODE)
        //    values
        //        (?, ?, ?, ?, ?, ?)
        //
        //insert
        //    into
        //        USER_ADDRESS
        //        (USER_ID, USER_ADDRESS_LINE_1, USER_ADDRESS_LINE_2, CITY, STATE, ZIP_CODE)
        //    values
        //        (?, ?, ?, ?, ?, ?)
    }
}
