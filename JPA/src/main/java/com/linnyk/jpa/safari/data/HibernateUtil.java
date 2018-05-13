package com.linnyk.jpa.safari.data;

import com.linnyk.jpa.safari.data.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private HibernateUtil() {
        // singleton class
    }

    private static SessionFactory buildSessionFactory() {
        try{
            final Configuration configuration = new Configuration();
//            configuration.addAnnotatedClass(User.class);
            return configuration
                    .buildSessionFactory(new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties())
                            .build());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
}
