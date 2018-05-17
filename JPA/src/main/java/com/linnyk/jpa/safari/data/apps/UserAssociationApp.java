package com.linnyk.jpa.safari.data.apps;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import com.linnyk.jpa.safari.data.entities.User;
import com.linnyk.jpa.safari.data.entities.association.Credential;
import com.linnyk.jpa.safari.data.util.HibernateUtil;

public class UserAssociationApp {

    @Test
    public void testOneToOneUnidirectional() {
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

        final Credential credential = new Credential();
        credential.setPassword("password");
        credential.setUsername("user");
        credential.setUser(user);

        session.save(credential);

        // Будет выполнено два insert:
        //
        // insert into FINANCES_USER (USER_ADDRESS_LINE_1, USER_ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, BIRTH_DATE, CREATED_BY, CREATED_DATE, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, LAST_UPDATED_BY, LAST_UPDATED_DATE, USER_ID)
        //             values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into CREDENTIAL (PASSWORD, USER_ID, USERNAME, CREDENTIAL_ID)
        //             values (?, ?, ?, ?)

        session.getTransaction().commit();

        User dbUser = session.get(User.class, credential.getUser().getUserId());
        System.out.println(dbUser.getFirstName()); //Oleh
        System.out.println(dbUser.getCredential()); //null

        session.close();
    }

    @Test
    public void testOneToOneBidirectional() {
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

        final Credential credential = new Credential();
        credential.setPassword("password");
        credential.setUsername("user");

        credential.setUser(user);
        user.setCredential(credential);

        session.save(credential);

        // Будет выполнено два insert:
        //
        // insert into FINANCES_USER (USER_ADDRESS_LINE_1, USER_ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, BIRTH_DATE, CREATED_BY, CREATED_DATE, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, LAST_UPDATED_BY, LAST_UPDATED_DATE, USER_ID)
        //                    values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        // insert into CREDENTIAL (PASSWORD, USER_ID, USERNAME, CREDENTIAL_ID) values (?, ?, ?, ?)

        session.getTransaction().commit();

        User dbUser = session.get(User.class, credential.getUser().getUserId());
        System.out.println(dbUser.getFirstName()); //Oleh
        System.out.println(dbUser.getCredential()); // Credential{credentialId=21, username='user', password='password'}

        session.close();
    }


}