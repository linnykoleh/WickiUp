package com.linnyk.jpa.tppc.app.association;

import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import com.linnyk.jpa.tppc.entities.association.one_to_one.bidirectional.Item_B;
import com.linnyk.jpa.tppc.entities.association.one_to_one.bidirectional.Statistic_B;
import com.linnyk.jpa.tppc.entities.association.one_to_one.unidirectional.Item_U;
import com.linnyk.jpa.tppc.entities.association.one_to_one.unidirectional.Statistic_U;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Date;

public class OneToOne {

    @Test
    public void test_One_To_One_Unidirectional(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        final Statistic_U statisticU = new Statistic_U(100, new Date());

        final Item_U itemU = new Item_U("Item 1", statisticU);

        entityManager.persist(itemU);

        // insert into STATISTIC (DATE, PRICE, STAT_ID) values (?, ?, ?)
        // insert into ITEM_OO_U (NAME, STAT_ID, ITEM_ID) values (?, ?, ?)

        /**

         ITEM_OO_U Table                                  STATISTIC_U Table
         ----------------------------                     -----------------------------
         | ITEM_ID | NAME  |*STAT_ID*|                    | *STAT_ID* | DATE  | PRICE |
         -----------------------------   <-------------   -----------------------------
         |  1	   |Item 1 |   2     |   1..1      1..1   |   2       | date  |   5   |
         -----------------------------                    -----------------------------

         */

        final Item_U item_u = entityManager.find(Item_U.class, 1L);
        System.out.println(item_u);
        // Item_U{*itemId*=1, name='Item 1', statisticU=Statistic_U{*statisticId*=2, price=100, date=Sun May 27 21:03:18 EEST 2018}}

        final Statistic_U statistic_U = entityManager.find(Statistic_U.class, 2L);
        System.out.println(statistic_U);
        //Statistic_U{statisticId=2, price=100, date=Sun May 27 21:03:18 EEST 2018}

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void test_One_To_One_Bidirectional(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        final Statistic_B statisticB = new Statistic_B(100, new Date());

        final Item_B itemB = new Item_B("Item 1", statisticB);

        statisticB.setItem_b(itemB);

        entityManager.persist(itemB);

        // insert into STATISTIC_B (DATE, PRICE, STAT_ID) values (?, ?, ?)
        // insert into ITEM_OO_B (NAME, STAT_ID, ITEM_ID) values (?, ?, ?)

        /**

         ITEM_OO_U Table                                  STATISTIC_B Table
         ----------------------------                     -----------------------------
         | ITEM_ID | NAME  |*STAT_ID*|                    | *STAT_ID* | DATE  | PRICE |
         -----------------------------   <-------------   -----------------------------
         |    1	   |Item 1 |   2     |   1..1      1..1   |     2     | date  |   5   |
         -----------------------------                    -----------------------------

         */

        final Item_B item_b = entityManager.find(Item_B.class, 1L);
        System.out.println(item_b);
        //Item_B{*itemId*=1, name='Item 1', statisticU=2}

        final Statistic_B statistic_b = entityManager.find(Statistic_B.class, 2L);
        System.out.println(statistic_b);
        //Statistic_B{statisticId=2, price=100, date=Sun May 27 21:11:16 EEST 2018, *item_b*=1}

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
