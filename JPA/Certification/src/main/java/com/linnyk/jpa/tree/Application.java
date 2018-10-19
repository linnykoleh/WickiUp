package com.linnyk.jpa.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.linnyk.jpa.safari.jpa_api.configuration.JPAFactoryBuilder;

public class Application {

	private static EntityManagerFactory entityManagerFactory;

	@BeforeClass
	public static void before() {
		entityManagerFactory = JPAFactoryBuilder.getEntityManagerFactory();
		initDB();
	}

	private static void initDB() {
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final FolderEntity folder1 = new FolderEntity();
		folder1.setName("Shared");

		final FolderEntity folder2 = new FolderEntity();
		folder2.setName("Folder2");
		folder2.setParentFolder(folder1);

		final LeafEntity leaf1 = new LeafEntity();
		leaf1.setName("Leaf1");
		leaf1.setContent("Leaf1Content");
		leaf1.setFolder(folder2);

		final FolderEntity folder3 = new FolderEntity();
		folder3.setName("Folder3");
		folder3.setParentFolder(folder1);

		final LeafEntity leaf2 = new LeafEntity();
		leaf2.setName("Leaf2");
		leaf2.setContent("Leaf2Content");
		leaf2.setFolder(folder3);

		final LeafEntity leaf5 = new LeafEntity();
		leaf5.setName("Leaf5");
		leaf5.setContent("Leaf5Content");
		leaf5.setFolder(folder3);

		final FolderEntity folder4 = new FolderEntity();
		folder4.setName("Folder4");
		folder4.setParentFolder(folder3);

		final LeafEntity leaf3 = new LeafEntity();
		leaf3.setName("Leaf3");
		leaf3.setContent("Leaf3Content");
		leaf3.setFolder(folder4);

		final FolderEntity folder5 = new FolderEntity();
		folder5.setName("Folder5");
		folder5.setParentFolder(folder3);

		final LeafEntity leaf4 = new LeafEntity();
		leaf4.setName("Leaf4");
		leaf4.setContent("Leaf4Content");
		leaf4.setFolder(folder5);

		entityManager.persist(leaf1);
		entityManager.persist(leaf2);
		entityManager.persist(leaf3);
		entityManager.persist(leaf4);
		entityManager.persist(leaf5);

		/*
		Hibernate: insert into EFOREX_FOLDER_DATA_SERIES (ID, NAME, FOLDER_PARENT_FK) values (null, ?, ?)
		Hibernate: insert into EFOREX_FOLDER_DATA_SERIES (ID, NAME, FOLDER_PARENT_FK) values (null, ?, ?)
		Hibernate: insert into EFOREX_DATA_SERIES (ID, CONTENT, FOLDER_FK, NAME) values (null, ?, ?, ?)
		Hibernate: insert into EFOREX_FOLDER_DATA_SERIES (ID, NAME, FOLDER_PARENT_FK) values (null, ?, ?)
		Hibernate: insert into EFOREX_DATA_SERIES (ID, CONTENT, FOLDER_FK, NAME) values (null, ?, ?, ?)
		Hibernate: insert into EFOREX_FOLDER_DATA_SERIES (ID, NAME, FOLDER_PARENT_FK) values (null, ?, ?)
		Hibernate: insert into EFOREX_DATA_SERIES (ID, CONTENT, FOLDER_FK, NAME) values (null, ?, ?, ?)
		Hibernate: insert into EFOREX_FOLDER_DATA_SERIES (ID, NAME, FOLDER_PARENT_FK) values (null, ?, ?)
		Hibernate: insert into EFOREX_DATA_SERIES (ID, CONTENT, FOLDER_FK, NAME) values (null, ?, ?, ?)
		Hibernate: insert into EFOREX_DATA_SERIES (ID, CONTENT, FOLDER_FK, NAME) values (null, ?, ?, ?)
		*/

		transaction.commit();
		entityManager.close();
	}

	@Test
	public void test_Level2_UP() {
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final LeafEntity leaf1 = entityManager.find(LeafEntity.class, 1L);
		final LeafEntity leaf2 = entityManager.find(LeafEntity.class, 2L);

		System.out.println(leaf1.toString());
		System.out.println(leaf2.toString());

		assertNotNull(leaf1);
		assertNotNull(leaf2);

		assertEquals(leaf1.getId(), Long.valueOf(1));
		assertEquals(leaf2.getId(), Long.valueOf(2));

		final FolderEntity folder1 = entityManager.find(FolderEntity.class, 1L);
		final FolderEntity folder2 = entityManager.find(FolderEntity.class, 2L);
		final FolderEntity folder3 = entityManager.find(FolderEntity.class, 3L);

		System.out.println(folder1.toString());
		System.out.println(folder2.toString());
		System.out.println(folder3.toString());

		assertNotNull(folder1);
		assertNotNull(folder2);
		assertNotNull(folder3);

		assertEquals(folder1.getId(), Long.valueOf(1));
		assertEquals(folder2.getId(), Long.valueOf(2));
		assertEquals(folder3.getId(), Long.valueOf(3));

		transaction.commit();
		entityManager.close();
	}

	@Test
	public void test_Level3_UP() {
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final LeafEntity leaf3 = entityManager.find(LeafEntity.class, 3L);
		final LeafEntity leaf4 = entityManager.find(LeafEntity.class, 4L);

		System.out.println(leaf3.toString());
		System.out.println(leaf4.toString());

		assertNotNull(leaf3);
		assertNotNull(leaf4);

		assertEquals(leaf3.getId(), Long.valueOf(3));
		assertEquals(leaf4.getId(), Long.valueOf(4));

		transaction.commit();
		entityManager.close();
	}

	@Test
	public void test_Level2_DOWN() {
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		final Query namedQueryFoldersChildren = entityManager.createNamedQuery(FolderEntity.FIND_FOLDERS_CHILDREN, FolderEntity.class);
		namedQueryFoldersChildren.setParameter("childId", 3L);

		final List<FolderEntity> resultListFolders = namedQueryFoldersChildren.getResultList();
		resultListFolders.forEach(System.out::println);

		assertNotNull(resultListFolders);
		assertEquals(resultListFolders.size(), 2);

		final Query namedQueryLeafsChildren = entityManager.createNamedQuery(FolderEntity.FIND_LEAFS_CHILDREN, LeafEntity.class);
		namedQueryLeafsChildren.setParameter("folderId", 3L);

		final List<LeafEntity> resultListLeafs = namedQueryLeafsChildren.getResultList();
		resultListLeafs.forEach(System.out::println);

		assertNotNull(resultListLeafs);
		assertEquals(resultListFolders.size(), 2);

		transaction.commit();
		entityManager.close();
	}

	@AfterClass
	public static void after() {
		entityManagerFactory.close();
	}
}
