package com.linnyk.jpa.safari.best_practicies.data.dao.interfaces;

import java.util.List;

import com.linnyk.jpa.safari.entities.User;

public interface UserDao extends Dao<User, Long>{

	List<User> findByFirstName(String firstName);

}
