package com.linnyk.jpa.safari.data;

import com.linnyk.jpa.safari.data.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY_XML = buildSessionFactoryXML();
    private static final SessionFactory SESSION_FACTORY_ANNOTATIONS = buildSessionFactoryAnnotation();

    private HibernateUtil() {
        // singleton class
    }

    /**
     * Used hibernate.cfg.xml
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
     * Used hibernate.properties
     */
    private static SessionFactory buildSessionFactoryAnnotation() {
        final Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
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