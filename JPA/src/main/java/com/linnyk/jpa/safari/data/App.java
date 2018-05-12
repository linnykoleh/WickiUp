package com.linnyk.jpa.safari.data;

import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.close();
    }
}
