package com.linnyk.jpa.safari.hibernate_api.mapping_examples;

import com.linnyk.jpa.safari.entities.TimeTest;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;

import org.hibernate.Session;
import org.junit.Test;

import java.util.Date;

public class TimeTestApp {

    @Test
    public void test() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryXML().openSession();
        session.beginTransaction();
        try{
            final TimeTest timeTest = new TimeTest(new Date());

            session.save(timeTest); //save

            session.getTransaction().commit();

            session.refresh(timeTest); //refresh

            System.out.println(timeTest);// TimeTest [
                                         //     timeTestId=2,
                                         //     datetimeColumn=2018-05-15 13:09:19.665,
                                         //     timestampColumn=2018-05-15 13:09:19.665,
                                         //     dateColumn=2018-05-15,
                                         //     timeColumn=13:09:19,
                                         //     sqlDatetimeColumn=2018-05-15 13:09:19.665,
                                         //     sqlTimestampColumn=2018-05-15 13:09:19.665,
                                         //     sqlDateColumn=2018-05-15,
                                         //     sqlTimeColumn=13:09:19]

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            HibernateFactoryBuilder.getSessionFactoryXML().close();
        }
    }
}
