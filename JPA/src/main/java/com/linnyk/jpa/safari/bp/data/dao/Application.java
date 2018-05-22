package com.linnyk.jpa.safari.bp.data.dao;

import org.hibernate.Transaction;

import com.linnyk.jpa.safari.bp.data.dao.interfaces.UserDao;
import com.linnyk.jpa.safari.entities.User;
import com.linnyk.jpa.safari.hibernate_api.configuration.HibernateFactoryBuilder;
import com.linnyk.jpa.safari.util.EntitiesUtil;

public class Application {

	public static void main(String[] args) {
		final UserDao userDao = new UserHibernateDao();
		userDao.setSession(HibernateFactoryBuilder.getSessionFactoryXML().openSession());

		final Transaction transaction = ((UserHibernateDao) userDao).getSession().beginTransaction();

		final User user = EntitiesUtil.getUser("Test", "test");

		userDao.save(user);

		transaction.commit();

		// insert into FINANCES_USER (USER_ADDRESS_LINE_1, USER_ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, BIRTH_DATE, CREATED_BY, CREATED_DATE, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, LAST_UPDATED_BY, LAST_UPDATED_DATE, USER_ID)
		// values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)

		((UserHibernateDao) userDao).getSession().close();

	}
}
