package com.linnyk.jpa.safari.hibernate_api.mapping_examples.embedded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.junit.Test;

import com.linnyk.jpa.safari.entities.embedded.Bank;
import com.linnyk.jpa.safari.util.EntitiesUtil;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;

public class BankApp {

    @Test
    public void testEmbeddable() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryAnnotation().openSession();

        try {
            session.beginTransaction();

            final Bank bank = EntitiesUtil.getBank("Federal Trust");

            session.save(bank);

        }finally {
            session.getTransaction().commit();
            session.close();
        }

    }

    @Test
    public void testCollectionTable() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryAnnotation().openSession();

        try {
            session.beginTransaction();

            final Bank bank = EntitiesUtil.getBank("Federal Trust");

            final List<String> contacts = new ArrayList<>();
            contacts.add("Joe");
            contacts.add("Mary");

            bank.setContacts(contacts);

            session.save(bank);

            // insert into BANK (BANK_ID, ADDRESS_LINE_1, ADDRESS_LINE_2, CITY,     STATE, ZIP_CODE, CREATED_BY,     CREATED_DATE,              IS_INTERNATIONAL, LAST_UPDATED_BY, LAST_UPDATED_DATE,         NAME)
            //           values (1,       33 Wall Street, Suite 2,        New York, NY,    27914,    Kevin Bowersox, 2018-05-16 16:24:41.15300, false,            Kevin Bowersox,  2018-05-16 16:24:41.15300, Federal Trust)
            //
            // insert into BANK_CONTACT (BANK_ID, NAME) values (1, Joe)
            // insert into BANK_CONTACT (BANK_ID, NAME) values (1, Mary)

        }finally {
            session.getTransaction().commit();
            session.close();
        }

    }

    @Test
    public void testMapTable() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryAnnotation().openSession();

        try {
            session.beginTransaction();

            final Bank bank = EntitiesUtil.getBank("Federal Trust");

            final Map<String, String> contactsMap = new HashMap<>();
            contactsMap.put("MANAGER", "Oleh");
            contactsMap.put("Teller", "Ira");

            bank.setContactsMap(contactsMap);

            session.save(bank);

        }finally {
            session.getTransaction().commit();
            session.close();
        }

    }

}
