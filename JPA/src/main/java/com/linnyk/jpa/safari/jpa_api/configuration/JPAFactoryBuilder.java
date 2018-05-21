package com.linnyk.jpa.safari.jpa_api.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactoryBuilder {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = buildEntityManagerFactory();

    private JPAFactoryBuilder() {
        // singleton class
    }

    /**
     * Use persistence.xml
     */
    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory("infinite-finances");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    public static EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }

}