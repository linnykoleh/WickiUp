package com.linnyk.jpa.safari.criteria.hql;

import com.linnyk.jpa.safari.entities.association.Transaction;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class HQLApp {

    @Test
    public void test_Simple_Selection(){
        final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
        final Session session = sessionFactoryXML.openSession();
        final org.hibernate.Transaction transaction = session.getTransaction();

        transaction.begin();

        // select t from Transaction t
        final Criteria criteria = session.createCriteria(Transaction.class);
        criteria.addOrder(Order.desc("title"));

        final List<Transaction> list = criteria.list();

        for(Transaction tran : list){
            System.out.println(tran.getTitle());
        }
        //Second transaction
        //Second transaction
        //First transaction
        //First transaction

        transaction.commit();
        session.close();
        sessionFactoryXML.close();
    }

    @Test
    public void test_Restriction(){
        final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
        final Session session = sessionFactoryXML.openSession();
        final org.hibernate.Transaction transaction = session.getTransaction();

        transaction.begin();

        // select this_.TRANSACTION_ID as TRANSACT1_13_1_, this_.ACCOUNT_ID as ACCOUNT12_13_1_, this_.AMOUNT as AMOUNT2_13_1_, this_.CLOSING_BALANCE as CLOSING_3_13_1_, this_.CREATED_BY as CREATED_4_13_1_, this_.CREATED_DATE as CREATED_5_13_1_, this_.INITIAL_BALANCE as INITIAL_6_13_1_, this_.LAST_UPDATED_BY as LAST_UPD7_13_1_, this_.LAST_UPDATED_DATE as LAST_UPD8_13_1_, this_.NOTES as NOTES9_13_1_, this_.TITLE as TITLE10_13_1_, this_.TRANSACTION_TYPE as TRANSAC11_13_1_, account2_.ACCOUNT_ID as ACCOUNT_1_0_0_, account2_.ACCOUNT_TYPE as ACCOUNT_2_0_0_, account2_.CLOSE_DATE as CLOSE_DA3_0_0_, account2_.CREATED_BY as CREATED_4_0_0_, account2_.CREATED_DATE as CREATED_5_0_0_, account2_.CURRENT_BALANCE as CURRENT_6_0_0_, account2_.INITIAL_BALANCE as INITIAL_7_0_0_, account2_.LAST_UPDATED_BY as LAST_UPD8_0_0_, account2_.LAST_UPDATED_DATE as LAST_UPD9_0_0_, account2_.NAME as NAME10_0_0_, account2_.OPEN_DATE as OPEN_DA11_0_0_
        // from TRANSACTION this_ left outer join ACCOUNT account2_ on this_.ACCOUNT_ID=account2_.ACCOUNT_ID
        // where this_.AMOUNT<=? and this_.TRANSACTION_TYPE=?
        // order by this_.TITLE desc

        final SimpleExpression amount = Restrictions.le("amount", new BigDecimal(20));
        final SimpleExpression transactionType = Restrictions.eq("transactionType", "Type 1");

        final Criteria criteria = session.createCriteria(Transaction.class)
                .add(amount)
                .add(transactionType)
                .addOrder(Order.desc("title"));

        final List<Transaction> list = criteria.list();

        for(Transaction tran : list){
            System.out.println(tran.getTitle());
        }
        //First transaction
        //First transaction

        transaction.commit();
        session.close();
        sessionFactoryXML.close();
    }

    @Test
    public void test_Paging(){
        final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
        final Session session = sessionFactoryXML.openSession();
        final org.hibernate.Transaction transaction = session.getTransaction();

        transaction.begin();

        // select this_.TRANSACTION_ID as TRANSACT1_13_1_, this_.ACCOUNT_ID as ACCOUNT12_13_1_, this_.AMOUNT as AMOUNT2_13_1_, this_.CLOSING_BALANCE as CLOSING_3_13_1_, this_.CREATED_BY as CREATED_4_13_1_, this_.CREATED_DATE as CREATED_5_13_1_, this_.INITIAL_BALANCE as INITIAL_6_13_1_, this_.LAST_UPDATED_BY as LAST_UPD7_13_1_, this_.LAST_UPDATED_DATE as LAST_UPD8_13_1_, this_.NOTES as NOTES9_13_1_, this_.TITLE as TITLE10_13_1_, this_.TRANSACTION_TYPE as TRANSAC11_13_1_, account2_.ACCOUNT_ID as ACCOUNT_1_0_0_, account2_.ACCOUNT_TYPE as ACCOUNT_2_0_0_, account2_.CLOSE_DATE as CLOSE_DA3_0_0_, account2_.CREATED_BY as CREATED_4_0_0_, account2_.CREATED_DATE as CREATED_5_0_0_, account2_.CURRENT_BALANCE as CURRENT_6_0_0_, account2_.INITIAL_BALANCE as INITIAL_7_0_0_, account2_.LAST_UPDATED_BY as LAST_UPD8_0_0_, account2_.LAST_UPDATED_DATE as LAST_UPD9_0_0_, account2_.NAME as NAME10_0_0_, account2_.OPEN_DATE as OPEN_DA11_0_0_
        // from TRANSACTION this_ left outer join ACCOUNT account2_ on this_.ACCOUNT_ID=account2_.ACCOUNT_ID
        // order by this_.TITLE
        // desc
        // limit ?
        // offset ?
        final Criteria criteria = session.createCriteria(Transaction.class);
        criteria.addOrder(Order.desc("title"));
        criteria.setFirstResult(1);
        criteria.setMaxResults(2);

        final List<Transaction> list = criteria.list();

        for(Transaction tran : list){
            System.out.println(tran.getTitle());
        }
        //Second transaction
        //Second transaction
        //First transaction
        //First transaction

        transaction.commit();
        session.close();
        sessionFactoryXML.close();
    }

}
