package com.linnyk.jpa.jee7.apps.order_by;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.order_by.Comment;
import com.linnyk.jpa.jee7.entities.order_by.News;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class OrderByApp {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Comment comment1 = new Comment("Nick 1", "Content 1", 1, new Date());
		final Comment comment2 = new Comment("Nick 2", "Content 2", 2, new Date());
		final Comment comment3 = new Comment("Nick 3", "Content 3", 3, new Date());

		final News news = new News("Content", Arrays.asList(comment1, comment2, comment3));

		entityManager.persist(news);
		transaction.commit();

		/**----------------------------------------------------*/

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();

		final News newsDB = entityManager.find(News.class, 1L);
		System.out.println(newsDB);
		System.out.println(newsDB.getComments());

		// select news0_.id as id1_41_0_, news0_.content as content2_41_0_, comments1_.News_id as News_id1_42_1_, comment2_.id as comments2_42_1_, comment2_.id as id1_23_2_, comment2_.content as content2_23_2_, comment2_.nickname as nickname3_23_2_, comment2_.note as note4_23_2_, comment2_.posted_date as posted_d5_23_2_
		// from News news0_
		// left outer join News_Comment comments1_ on news0_.id=comments1_.News_id
		// left outer join Comment comment2_ on comments1_.comments_id=comment2_.id
		// where news0_.id=?
		// order by comment2_.posted_date desc
		//
		// News{id=1, content='Content'}
		// [Comment{id=2, nickname='Nick 1', content='Content 1', note=1, postedDate=2018-06-01 16:14:12.2}, Comment{id=3, nickname='Nick 2', content='Content 2', note=2, postedDate=2018-06-01 16:14:12.2}, Comment{id=4, nickname='Nick 3', content='Content 3', note=3, postedDate=2018-06-01 16:14:12.2}]

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
