package com.linnyk.jpa.tppc.app.association;

import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import com.linnyk.jpa.tppc.entities.association.many_to_one__one_to_many.bidirectional.BidB;
import com.linnyk.jpa.tppc.entities.association.many_to_one__one_to_many.bidirectional.ItemB;
import com.linnyk.jpa.tppc.entities.association.many_to_one__one_to_many.unidirectional.BidU;
import com.linnyk.jpa.tppc.entities.association.many_to_one__one_to_many.unidirectional.ItemU;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

public class ManyToOne_OneToMany {

    @Test
    public void test_Many_To_One_Unidirectional(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        final ItemU item = new ItemU("EUR/USD");

        final BidU bid1 = new BidU(new BigDecimal(123.55), item);
        final BidU bid2 = new BidU(new BigDecimal(136.45), item);
        final BidU bid3 = new BidU(new BigDecimal(183.15), item);

        entityManager.persist(item);
        entityManager.persist(bid1);
        entityManager.persist(bid2);
        entityManager.persist(bid3);

        //insert into ITEM (NAME, ITEM_ID) values (?, ?)
        //insert into BID_U (ITEM_ID, PRICE, BID_ID) values (?, ?, ?)
        //insert into BID_U (ITEM_ID, PRICE, BID_ID) values (?, ?, ?)
        //insert into BID_U (ITEM_ID, PRICE, BID_ID) values (?, ?, ?)

        /**

         ITEM_U Table                          BID_U Table
         -------------------                   -----------------------------
         |*ITEM_ID*| NAME  |                   | BID_ID | PRICE  |*ITEM_ID*|
         -------------------  <-------------   -----------------------------
         |   5	   |EUR/USD|  1..1      0..*   |   6    | 123.55 | 	 5     |
         -------------------                   |   7    | 136.45 | 	 5     |
                                               |   8    | 183.15 |	 5     |
                                               -----------------------------
         */

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void test_Many_To_One_Bidirectional(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        final ItemB item = new ItemB("EUR/USD");

        final BidB bid1 = new BidB(new BigDecimal(123.55), item);
        final BidB bid2 = new BidB(new BigDecimal(136.45), item);
        final BidB bid3 = new BidB(new BigDecimal(183.15), item);

        item.getBidB().add(bid1);
        item.getBidB().add(bid2);
        item.getBidB().add(bid3);

        entityManager.persist(item);

        //insert into ITEM_B (NAME, ITEM_ID) values (?, ?)
        //insert into BID_B (ITEM_ID, PRICE, BID_ID) values (?, ?, ?)
        //insert into BID_B (ITEM_ID, PRICE, BID_ID) values (?, ?, ?)
        //insert into BID_B (ITEM_ID, PRICE, BID_ID) values (?, ?, ?)

        /**

         ITEM_B Table                          BID_B Table
         -------------------                   -----------------------------
         |*ITEM_ID*| NAME  |                   | BID_ID | PRICE  |*ITEM_ID*|
         -------------------  <------------->  |--------|--------|---------|
         |   9	   |EUR/USD|  1..1      0..*   |   10   | 123.55 | 	 9     |
         -------------------                   |   11   | 136.45 | 	 9     |
                                               |   12   | 183.15 |	 9     |
                                               -----------------------------
         */

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
