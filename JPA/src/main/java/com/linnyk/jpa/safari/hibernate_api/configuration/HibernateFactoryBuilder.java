package com.linnyk.jpa.safari.hibernate_api.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.linnyk.jpa.safari.entities.TimeTest;
import com.linnyk.jpa.safari.entities.User;
import com.linnyk.jpa.safari.entities.association.Account;
import com.linnyk.jpa.safari.entities.association.Credential;
import com.linnyk.jpa.safari.entities.association.Transaction;
import com.linnyk.jpa.safari.entities.embedded.Bank;
import com.linnyk.jpa.safari.entities.generation_type.UserGTAuto;
import com.linnyk.jpa.safari.entities.generation_type.UserGTIdentity;
import com.linnyk.jpa.safari.entities.generation_type.UserGTSequence;
import com.linnyk.jpa.safari.entities.generation_type.UserGTTable;
import com.linnyk.jpa.safari.entities.generation_type.UserNoGT;
import com.linnyk.jpa.safari.entities.join_table.Budget;

public class HibernateFactoryBuilder {

    private static final SessionFactory SESSION_FACTORY_XML = buildSessionFactoryXML();
    private static final SessionFactory SESSION_FACTORY_ANNOTATIONS = buildSessionFactoryAnnotation();

    private HibernateFactoryBuilder() {
        // singleton class
    }

    /**
     * Use hibernate.cfg.xml
     */
    private static SessionFactory buildSessionFactoryXML() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Use hibernate.properties
     */
    private static SessionFactory buildSessionFactoryAnnotation() {
        final Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(UserGTTable.class);
        configuration.addAnnotatedClass(UserGTSequence.class);
        configuration.addAnnotatedClass(UserGTIdentity.class);
        configuration.addAnnotatedClass(UserGTAuto.class);
        configuration.addAnnotatedClass(UserNoGT.class);
        configuration.addAnnotatedClass(TimeTest.class);
        configuration.addAnnotatedClass(Bank.class);
        configuration.addAnnotatedClass(Credential.class);
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Transaction.class);
        configuration.addAnnotatedClass(Budget.class);

        return configuration
                .buildSessionFactory(new StandardServiceRegistryBuilder()
                        .build());

    }

    public static SessionFactory getSessionFactoryXML() {
        return SESSION_FACTORY_XML;
    }

    public static SessionFactory getSessionFactoryAnnotation() {
        return SESSION_FACTORY_ANNOTATIONS;
    }

}