package com.linnyk.jpa.safari.query_language.hql;

import com.linnyk.jpa.safari.entities.association.Transaction;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class HQLApp {

    @Test
    public void test(){
        final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
        final Session session = sessionFactoryXML.openSession();
        final org.hibernate.Transaction transaction = session.getTransaction();

        transaction.begin();

        final Query query = session.createQuery("select t from Transaction t");
        final List<Transaction> list = query.list();

        for (Transaction tran : list) {
            System.out.println(tran);
        }
        // select account0_.ACCOUNT_ID as ACCOUNT_1_0_0_, account0_.ACCOUNT_TYPE as ACCOUNT_2_0_0_, account0_.CLOSE_DATE as CLOSE_DA3_0_0_, account0_.CREATED_BY as CREATED_4_0_0_, account0_.CREATED_DATE as CREATED_5_0_0_, account0_.CURRENT_BALANCE as CURRENT_6_0_0_, account0_.INITIAL_BALANCE as INITIAL_7_0_0_, account0_.LAST_UPDATED_BY as LAST_UPD8_0_0_, account0_.LAST_UPDATED_DATE as LAST_UPD9_0_0_, account0_.NAME as NAME10_0_0_, account0_.OPEN_DATE as OPEN_DA11_0_0_ from ACCOUNT account0_ where account0_.ACCOUNT_ID=?
        // Transaction{transactionId=21, transactionType='Type 1', title='First transaction', amount=10.00, account=com.linnyk.jpa.safari.entities.Account@17814b1c, initialBalance=10.00, closingBalance=1.00, notes='null', lastUpdatedDate=2018-05-23 21:55:07.825, lastUpdatedBy='Oleh', createdDate=2018-05-23 21:55:07.825, createdBy='Oleh'}
        // Transaction{transactionId=22, transactionType='Type 2', title='Second transaction', amount=10.00, account=com.linnyk.jpa.safari.entities.Account@17814b1c, initialBalance=10.00, closingBalance=1.00, notes='null', lastUpdatedDate=2018-05-23 21:55:07.825, lastUpdatedBy='Oleh', createdDate=2018-05-23 21:55:07.825, createdBy='Oleh'}

        transaction.commit();
        session.close();
        sessionFactoryXML.close();
    }
}
