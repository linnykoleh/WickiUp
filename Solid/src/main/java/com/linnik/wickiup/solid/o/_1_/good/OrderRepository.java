package com.linnik.wickiup.solid.o._1_.good;

/**
 * @author LinnykOleh
 */
public class OrderRepository {

	private IOrderSource source;

	public void setSource(IOrderSource source) {
		this.source = source;
	}

	public void load(int orderId) {
		this.source.load(orderId);
	}

	public void save(Object order){
		this.source.save(order);
	}

	public void update(Object order){
		this.source.update(order);
	}

	public void delete(Object order){
		this.source.delete(order);
	}
}
