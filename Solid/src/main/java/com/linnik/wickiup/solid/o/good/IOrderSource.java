package com.linnik.wickiup.solid.o.good;

/**
 * @author LinnykOleh
 */
public interface IOrderSource {

	void load(int orderId);

	void save(Object order);

	void update(Object order);

	void delete(Object order);

}
