package com.linnyk.jpa.safari.mapping_examples;

import com.linnyk.jpa.safari.entities.TimeTest;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;

import org.hibernate.Session;
import org.junit.Test;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeTestApp {

    @Test
    public void test() {
        final Session session = HibernateFactoryBuilder.getSessionFactoryXML().openSession();
        session.beginTransaction();

        final TimeTest timeTest = new TimeTest(new Date());

        session.save(timeTest); //save
        session.getTransaction().commit();

        System.out.println(timeTest);
        //TimeTest(
        // timeTestId=5, datetimeColumn=Wed Oct 24 09:18:35 CEST 2018,
        // timestampColumn=Wed Oct 24 09:18:35 CEST 2018,
        // dateColumn=Wed Oct 24 09:18:35 CEST 2018,
        // timeColumn=Wed Oct 24 09:18:35 CEST 2018,
        // sqlDatetimeColumn=2018-10-24 09:18:35.77,
        // sqlTimestampColumn=2018-10-24 09:18:35.77,
        // sqlDateColumn=2018-10-24,
        // sqlTimeColumn=09:18:35,
        // localDateTimeColumn=2018-10-24T09:18:35.770,
        // localDateColumn=2018-10-24)

        session.close();
        HibernateFactoryBuilder.getSessionFactoryXML().close();
    }
}
