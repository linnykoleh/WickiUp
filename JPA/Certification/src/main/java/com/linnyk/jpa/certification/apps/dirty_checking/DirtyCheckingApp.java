package com.linnyk.jpa.certification.apps.dirty_checking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;

import com.linnyk.jpa.certification.entities.dirty_checking.Page;
import com.linnyk.jpa.certification.entities.dirty_checking.Site;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;
import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class DirtyCheckingApp {

	/**
	 * Chick this method in order to know how dirtyChecking works
	 *
	 * org.hibernate.event.internal.DefaultFlushEntityEventListener#dirtyCheck(org.hibernate.event.spi.FlushEntityEvent)
	 */
	@Test
	public void test(){
		persistSiteAndPages();

		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Site> query = criteriaBuilder.createQuery(Site.class);

		final Root root = query.from(Site.class);
		query.select(root);
		root.join("pages");

		final TypedQuery<Site> typedQuery = entityManager.createQuery(query);
		final List<Site> sites = typedQuery.getResultList();

		for (Site site : sites) {
			System.out.println(site);
			System.out.println(site.getPages());
		}


		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}


	@Test
	public void hibernateSetReadOnlyTrue() {
		persistSiteAndPages();

		final SessionFactory sessionFactoryXML = HibernateFactoryBuilder.getSessionFactoryXML();
		final Session session = sessionFactoryXML.openSession();
		final org.hibernate.Transaction transaction = session.getTransaction();
		transaction.begin();

		final Query<Site> sitesQuery = session.createQuery("select s from Site s inner join s.pages p", Site.class)
				.setReadOnly(true); //need to prevent dirty checking
		final List<Site> sites = sitesQuery.getResultList();

		for (Site site : sites) {
			System.out.println(site);
			System.out.println(site.getPages());
		}

		transaction.commit();
		session.close();
		sessionFactoryXML.close();
	}

	private void persistSiteAndPages() {
		final EntityManagerFactory entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Page page1 = new Page("Home", "The home page");
		final Page page2 = new Page("About", "The about page");
		final Page page3 = new Page("Contact", "The contact page");

		final Site site = new Site("Sale Shop");
		Set<Page> sites = new HashSet<>();
		sites.add(page1);
		sites.add(page2);
		sites.add(page3);
		site.setPages(sites);

		entityManager.persist(site);

		transaction.commit();
		entityManager.close();
	}

}
