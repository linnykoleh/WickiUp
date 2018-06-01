package com.linnyk.jpa.jee7.apps.many_to_many;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.linnyk.jpa.jee7.entities.many_to_many.Artist;
import com.linnyk.jpa.jee7.entities.many_to_many.CD;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class ManyToManyBidirectional {

	@Test
	public void test(){
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Artist artist1 = new Artist("Artist 1", "Artist 1");
		final Artist artist2 = new Artist("Artist 2", "Artist 2");
		final Artist artist3 = new Artist("Artist 3", "Artist 3");

		final CD cd1 = new CD("Title 1", 12F, "Description 1", Arrays.asList(artist1, artist2, artist3));
		final CD cd2 = new CD("Title 2", 76F, "Description 2", Arrays.asList(artist1, artist2, artist3));
		final CD cd3 = new CD("Title 3", 42F, "Description 3", Arrays.asList(artist1, artist2, artist3));

		artist1.setAppearsOnCDs(Arrays.asList(cd1, cd2, cd3));
		artist2.setAppearsOnCDs(Arrays.asList(cd1, cd3));
		artist3.setAppearsOnCDs(Arrays.asList(cd2, cd3));

		entityManager.persist(artist1);
		entityManager.persist(artist2);
		entityManager.persist(artist3);
		//Hibernate: insert into Artist (firstName, lastName, id) values (?, ?, ?)
		//Hibernate: insert into Artist (firstName, lastName, id) values (?, ?, ?)
		//Hibernate: insert into Artist (firstName, lastName, id) values (?, ?, ?)
		//
		//Hibernate: insert into CD (description, price, title, id) values (?, ?, ?, ?)
		//Hibernate: insert into CD (description, price, title, id) values (?, ?, ?, ?)
		//Hibernate: insert into CD (description, price, title, id) values (?, ?, ?, ?)
		//
		//Hibernate: insert into jnd_art_cd (artist_fk, cd_fk) values (?, ?)
		//Hibernate: insert into jnd_art_cd (artist_fk, cd_fk) values (?, ?)
		//Hibernate: insert into jnd_art_cd (artist_fk, cd_fk) values (?, ?)
		//Hibernate: insert into jnd_art_cd (artist_fk, cd_fk) values (?, ?)
		//Hibernate: insert into jnd_art_cd (artist_fk, cd_fk) values (?, ?)
		//Hibernate: insert into jnd_art_cd (artist_fk, cd_fk) values (?, ?)
		//Hibernate: insert into jnd_art_cd (artist_fk, cd_fk) values (?, ?)

		/**

		      ARTIST
		 -----------------------------
		 | ID | FIRSTNAME | LASTNAME |
		 -----------------------------
		 | 1  |	Artist 1  |	Artist 1 |
		 | 5  |	Artist 2  |	Artist 2 |
		 | 6  |	Artist 3  |	Artist 3 |
		 -----------------------------
	        |
		    *   JND_ART_CD
		 ---------------------
		 |*ARTIST_FK*|*CD_FK*|
		 ---------------------
		 |	 1		 |	 2   |
		 |	 1		 |	 3   |
		 |	 1		 |	 4   |
		 |	 5		 |	 2   |
		 |	 5		 |	 4   |
		 |   6 		 |	 3   |
		 |   6  	 |	 4	 |
         --------------------
           				*
           |-------------
		   |    CD
		 ----------------------------------------
		 | ID | DESCRIPTION   | PRICE | TITLE   |
		 ----------------------------------------
		 | 2  |	Description 1 |	12	  | Title 1 |
		 | 3  |	Description 2 |	76	  | Title 2 |
		 | 4  |	Description 3 |	42	  | Title 3 |
		 ----------------------------------------

		 */

		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
