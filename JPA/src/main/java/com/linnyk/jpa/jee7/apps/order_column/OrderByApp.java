package com.linnyk.jpa.jee7.apps.order_column;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.order_column.Comment;
import com.linnyk.jpa.jee7.entities.order_column.News;
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
		// insert into NEWS_OC (content, id) values (?, ?)
		// insert into COMMENT_OC (content, nickname, note, posted_date, id) values (?, ?, ?, ?, ?)
		// insert into COMMENT_OC (content, nickname, note, posted_date, id) values (?, ?, ?, ?, ?)
		// insert into COMMENT_OC (content, nickname, note, posted_date, id) values (?, ?, ?, ?, ?)
		// insert into NEWS_OC_COMMENT_OC (News_id, posted_index, comments_id) values (?, ?, ?)
		// insert into NEWS_OC_COMMENT_OC (News_id, posted_index, comments_id) values (?, ?, ?)
		// insert into NEWS_OC_COMMENT_OC (News_id, posted_index, comments_id) values (?, ?, ?)

		/**

		 NEWS_OC_COMMENT_OC
		 ----------------------------------------
		 | NEWS_ID | COMMENTS_ID | POSTED_INDEX |
		 ----------------------------------------
		 |   1	   |	2		 |	    0       |
		 |   1	   |	3		 |	    1       |
		 |   1	   |	4		 |	    2       |
	     ----------------------------------------

		 */
		/**----------------------------------------------------*/

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();

		final News newsDB = entityManager.find(News.class, 1L);
		System.out.println(newsDB);
		System.out.println(newsDB.getComments());

		// select news0_.id as id1_46_0_, news0_.content as content2_46_0_, comments1_.News_id as News_id1_47_1_, comment2_.id as comments2_47_1_, comments1_.posted_index as posted_i3_1_, comment2_.id as id1_24_2_, comment2_.content as content2_24_2_, comment2_.nickname as nickname3_24_2_, comment2_.note as note4_24_2_, comment2_.posted_date as posted_d5_24_2_
		// from NEWS_OC news0_
		// left outer join NEWS_OC_COMMENT_OC comments1_ on news0_.id=comments1_.News_id
		// left outer join COMMENT_OC comment2_ on comments1_.comments_id=comment2_.id
		// where news0_.id=?
		//
		//News{id=1, content='Content'}
		//[Comment{id=2, nickname='Nick 1', content='Content 1', note=1, postedDate=2018-06-01 16:48:49.497}, Comment{id=3, nickname='Nick 2', content='Content 2', note=2, postedDate=2018-06-01 16:48:49.497}, Comment{id=4, nickname='Nick 3', content='Content 3', note=3, postedDate=2018-06-01 16:48:49.497}]

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
