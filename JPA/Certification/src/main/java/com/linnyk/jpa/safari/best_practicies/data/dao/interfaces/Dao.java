package com.linnyk.jpa.safari.best_practicies.data.dao.interfaces;

import java.util.List;

import org.hibernate.Session;

public interface Dao<T,ID> {

	T findById(ID id);

	List<T> findAll();

	T save(T entity);

	void delete(T entity);

	void flush();

	void clear();

	void setSession(Session session);


}
