package com.linnyk.jpa.safari.query_language.hql;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;

import com.linnyk.jpa.safari.entities.Account;
import com.linnyk.jpa.safari.entities.association.Transaction;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;

public class HQLApp {

    @Test
    public void test_Simple_Query(){
        final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
        final Session session = sessionFactoryXML.openSession();
        final org.hibernate.Transaction transaction = session.getTransaction();

        transaction.begin();

        /* Transaction - это ентити.класс, а не таблица*/
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

    @Test
    public void test_Expression_Operators(){
        final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
        final Session session = sessionFactoryXML.openSession();
        final org.hibernate.Transaction transaction = session.getTransaction();

        transaction.begin();

        final Query query = session.createQuery("select t from Transaction t "
                + "where t.amount > 25 and t.transactionType = 'Withdrawl'");

        final List<Transaction> list = query.list();

        for (Transaction tran : list) {
            System.out.println(tran);
        }

        transaction.commit();
        session.close();
        sessionFactoryXML.close();
    }

    @Test
    public void test_Parameters(){
        final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
        final Session session = sessionFactoryXML.openSession();
        final org.hibernate.Transaction transaction = session.getTransaction();

        transaction.begin();

//       final Query query = session.createQuery("select t from Transaction t "
//               + "where t.amount > ? and t.transactionType = ?");
//       Вместо ? лучше использовать имена параметров

        final Query query = session.createQuery("select t from Transaction t "
                + "where t.amount > :amount and t.transactionType = :transactionType");
        query.setParameter("amount", new BigDecimal(25));
        query.setParameter("transactionType", "Withdrawl");

        final List<Transaction> list = query.list();

        for (Transaction tran : list) {
            System.out.println(tran);
        }

        transaction.commit();
        session.close();
        sessionFactoryXML.close();
    }

    @Test
    public void test_Joins(){
        final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
        final Session session = sessionFactoryXML.openSession();
        final org.hibernate.Transaction transaction = session.getTransaction();

        transaction.begin();

        final Query query = session.createQuery("select distinct t.account from Transaction t"
                + " where t.amount > 5 or t.transactionType = 'Deposit'");
        final List<Account> list = query.list();
        // select distinct account1_.ACCOUNT_ID as ACCOUNT_1_0_, account1_.ACCOUNT_TYPE as ACCOUNT_2_0_, account1_.CLOSE_DATE as CLOSE_DA3_0_, account1_.CREATED_BY as CREATED_4_0_, account1_.CREATED_DATE as CREATED_5_0_, account1_.CURRENT_BALANCE as CURRENT_6_0_, account1_.INITIAL_BALANCE as INITIAL_7_0_, account1_.LAST_UPDATED_BY as LAST_UPD8_0_, account1_.LAST_UPDATED_DATE as LAST_UPD9_0_, account1_.NAME as NAME10_0_, account1_.OPEN_DATE as OPEN_DA11_0_ from TRANSACTION transactio0_
        // inner join ACCOUNT account1_ on transactio0_.ACCOUNT_ID=account1_.ACCOUNT_ID
        // where transactio0_.AMOUNT>5 or transactio0_.TRANSACTION_TYPE='Deposit'

        for (Account account : list) {
            System.out.println(account.getName());
        }
        //Account

        transaction.commit();
        session.close();
        sessionFactoryXML.close();
    }

    @Test
    public void test_Functions(){
        final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
        final Session session = sessionFactoryXML.openSession();
        final org.hibernate.Transaction transaction = session.getTransaction();

        transaction.begin();

        final Query query = session.createQuery("select distinct t.account from Transaction t"
                + " where t.amount > 5 or lower(t.transactionType) = 'deposit'");
        final List<Account> list = query.list();

        for (Account account : list) {
            System.out.println(account.getName());
        }
        //Account

        transaction.commit();
        session.close();
        sessionFactoryXML.close();
    }

    @Test
    public void test_Named_Query(){
        final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
        final Session session = sessionFactoryXML.openSession();
        final org.hibernate.Transaction transaction = session.getTransaction();

        transaction.begin();

        final Query namedQuery = session.createNamedQuery("Account.largeDeposits");
        final List<Account> list = namedQuery.list();

        for (Account accountNQ : list) {
            System.out.println(accountNQ.getName());
        }
        // Account

        transaction.commit();
        session.close();
        sessionFactoryXML.close();
    }

    @Test
    public void test_Fetch_Lazy(){
        final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
        final Session session = sessionFactoryXML.openSession();
        final org.hibernate.Transaction transaction = session.getTransaction();

        transaction.begin();

        final Query namedQuery = session.createQuery("select a from Account a");
        final List<Account> list = namedQuery.list();
        // select contactsma0_.BANK_ID as BANK_ID1_2_0_, contactsma0_.NAME as NAME2_2_0_, contactsma0_.POSITION_TYPE as POSITION3_0_ from BANK_CONTACT contactsma0_
        // where contactsma0_.BANK_ID=?

        for (Account account : list) {
            System.out.println(account.getBank());
            // select contacts0_.BANK_ID as BANK_ID1_2_0_, contacts0_.NAME as NAME2_2_0_ from BANK_CONTACT contacts0_
            // where contacts0_.BANK_ID=?
            // [Bank{bankId=2, name='Federal Trust', account=com.linnyk.jpa.safari.entities.Account@54562ea6, address=Address{addressLine1='33 Wall Street', addressLine2='Suite 2', city='New York', state='NY', zipCode='27914'}, international=false, lastUpdatedDate=2018-05-24 09:59:52.033, lastUpdatedBy='Kevin Bowersox', createdDate=2018-05-24 09:59:52.033, createdBy='Kevin Bowersox', contactsMap={}, contacts=[]}]
        }

        transaction.commit();
        session.close();
        sessionFactoryXML.close();
    }
}
