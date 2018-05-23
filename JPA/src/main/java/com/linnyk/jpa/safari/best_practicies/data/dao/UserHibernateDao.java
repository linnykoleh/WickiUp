package com.linnyk.jpa.safari.best_practicies.data.dao;

import java.util.List;

import com.linnyk.jpa.safari.best_practicies.data.dao.interfaces.UserDao;
import com.linnyk.jpa.safari.entities.User;

public class UserHibernateDao extends AbstractDao<User, Long> implements UserDao {

	@Override
	public List<User> findByFirstName(String firstName) {
		//add implementation here...
		return null;
	}

}
