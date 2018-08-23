package com.linnyk.jpa.tppc.app.association;

import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;
import com.linnyk.jpa.tppc.entities.association.many_to_many.bidirectional.CategoryB;
import com.linnyk.jpa.tppc.entities.association.many_to_many.bidirectional.ItemB;
import com.linnyk.jpa.tppc.entities.association.many_to_many.unidirectional.CategoryU;
import com.linnyk.jpa.tppc.entities.association.many_to_many.unidirectional.ItemU;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Arrays;

public class ManyToMany {

    @Test
    public void test_Many_To_Many_Unidirectional(){
        final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        final ItemU itemU1 = new ItemU("Item 1");
        final ItemU itemU2 = new ItemU("Item 2");
        final ItemU itemU3 = new ItemU("Item 3");

        final CategoryU categoryU1 = new CategoryU("Category 1", Arrays.asList(itemU1, itemU2, itemU3));
        final CategoryU categoryU2 = new CategoryU("Category 2", Arrays.asList(itemU1, itemU2, itemU3));
        final CategoryU categoryU3 = new CategoryU("Category 3", Arrays.asList(itemU1, itemU2, itemU3));

        // insert into ITEM_MM_U (NAME, ITEM_ID) values (?, ?)
        // insert into ITEM_MM_U (NAME, ITEM_ID) values (?, ?)
        // insert into ITEM_MM_U (NAME, ITEM_ID) values (?, ?)
        //
        // insert into CATEGORY_MM_U (CATEGORY_NAME, CATEGORY_ID) values (?, ?)
        // insert into CATEGORY_MM_U (CATEGORY_NAME, CATEGORY_ID) values (?, ?)
        // insert into CATEGORY_MM_U (CATEGORY_NAME, CATEGORY_ID) values (?, ?)
        //
        // insert into CATEGORY_ITEM (CATEGORY_ID, ITEM_ID) values (?, ?)
        // insert into CATEGORY_ITEM (CATEGORY_ID, ITEM_ID) values (?, ?)
        // insert into CATEGORY_ITEM (CATEGORY_ID, ITEM_ID) values (?, ?)
        // insert into CATEGORY_ITEM (CATEGORY_ID, ITEM_ID) values (?, ?)
        // insert into CATEGORY_ITEM (CATEGORY_ID, ITEM_ID) values (?, ?)
        // insert into CATEGORY_ITEM (CATEGORY_ID, ITEM_ID) values (?, ?)
        // insert into CATEGORY_ITEM (CATEGORY_ID, ITEM_ID) values (?, ?)
        // insert into CATEGORY_ITEM (CATEGORY_ID, ITEM_ID) values (?, ?)
        // insert into CATEGORY_ITEM (CATEGORY_ID, ITEM_ID) values (?, ?)


        /**

                        CATEGORY_ITEM
                       ---------------------------------
    |----------------> |   *ITEM_ID*  |  *CATEGORY_ID* | <--|
    |                  ---------------------------------    |
    |                  |       2      |        1       |    |
    |                  |       3      |        1       |    |
    |                  |       4      |        1       |    |
    |                  |       2      |        5       |    |
    |                  |       3      |        5       |    |
    |                  |       4      |        5       |    |
    |                  |       2      |        6       |    |
    |                  |       3      |        6       |    |
    |                  |       4      |        6       |    |
    |                  ---------------------------------    |
    |                                                       |
    |                                                       |
    | 1..*                                             1..* |
    |                                                       |
    |    ITEM_MM_U                                          |   CATEGORY_MM_U
    |    -------------------                                |  --------------------------------
    ----|*ITEM_ID*| NAME  |                                 ---|*CATEGORY_ID*|  CATEGORY_NAME |
        -------------------                                    --------------------------------
        |   2    | Item 1 |                                    |    1	       |  Category 1    |
        |   3    | Item 2 |                                    |    5	       |  Category 2    |
        |   4    | Item 3 |                                    |    6	       |  Category 3    |
        -------------------                                    --------------------------------



         */

        entityManager.persist(categoryU1);
        entityManager.persist(categoryU2);
        entityManager.persist(categoryU3);

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

        final ItemB itemU1 = new ItemB("Item 1");
        final ItemB itemU2 = new ItemB("Item 2");
        final ItemB itemU3 = new ItemB("Item 3");

        final CategoryB categoryB1 = new CategoryB("Category 1", Arrays.asList(itemU1, itemU2, itemU3));
        final CategoryB categoryB2 = new CategoryB("Category 2", Arrays.asList(itemU1, itemU2, itemU3));
        final CategoryB categoryB3 = new CategoryB("Category 3", Arrays.asList(itemU1, itemU2, itemU3));

        itemU1.setCategories(Arrays.asList(categoryB1, categoryB2, categoryB3));
        itemU2.setCategories(Arrays.asList(categoryB1, categoryB2, categoryB3));
        itemU3.setCategories(Arrays.asList(categoryB1, categoryB2, categoryB3));

        entityManager.persist(categoryB1);
        entityManager.persist(categoryB2);
        entityManager.persist(categoryB3);

        //insert into ITEM_MM_B (NAME, ITEM_ID) values (?, ?)
        //insert into ITEM_MM_B (NAME, ITEM_ID) values (?, ?)
        //insert into ITEM_MM_B (NAME, ITEM_ID) values (?, ?)

        //insert into CATEGORY_MM_B (CATEGORY_NAME, CATEGORY_ID) values (?, ?)
        //insert into CATEGORY_MM_B (CATEGORY_NAME, CATEGORY_ID) values (?, ?)
        //insert into CATEGORY_MM_B (CATEGORY_NAME, CATEGORY_ID) values (?, ?)

        //insert into CATEGORY_ITEM_B (CATEGORY_ID, ITEM_ID) values (?, ?)
        //insert into CATEGORY_ITEM_B (CATEGORY_ID, ITEM_ID) values (?, ?)
        //insert into CATEGORY_ITEM_B (CATEGORY_ID, ITEM_ID) values (?, ?)
        //insert into CATEGORY_ITEM_B (CATEGORY_ID, ITEM_ID) values (?, ?)
        //insert into CATEGORY_ITEM_B (CATEGORY_ID, ITEM_ID) values (?, ?)
        //insert into CATEGORY_ITEM_B (CATEGORY_ID, ITEM_ID) values (?, ?)
        //insert into CATEGORY_ITEM_B (CATEGORY_ID, ITEM_ID) values (?, ?)
        //insert into CATEGORY_ITEM_B (CATEGORY_ID, ITEM_ID) values (?, ?)
        //insert into CATEGORY_ITEM_B (CATEGORY_ID, ITEM_ID) values (?, ?)

        /**

                             CATEGORY_ITEM_B
                            ---------------------------------
         |----------------> |   *ITEM_ID*  |  *CATEGORY_ID* | <--|
         |                  ---------------------------------    |
         |                  |       2      |        1       |    |
         |                  |       3      |        1       |    |
         |                  |       4      |        1       |    |
         |                  |       2      |        5       |    |
         |                  |       3      |        5       |    |
         |                  |       4      |        5       |    |
         |                  |       2      |        6       |    |
         |                  |       3      |        6       |    |
         |                  |       4      |        6       |    |
         |                  ---------------------------------    |
         |                                                       |
         |                                                       |
         | 1..*                                             1..* |
         |                                                       |
         |     ITEM_MM_B                                         |    CATEGORY_MM_B
         |    -------------------                                |   --------------------------------
         -----|*ITEM_ID*| NAME  |                                ----|*CATEGORY_ID*|  CATEGORY_NAME |
              -------------------                                    --------------------------------
              |   2    | Item 1 |                                    |    1	       |  Category 1    |
              |   3    | Item 2 |                                    |    5	       |  Category 2    |
              |   4    | Item 3 |                                    |    6	       |  Category 3    |
              -------------------                                    --------------------------------



         */

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
