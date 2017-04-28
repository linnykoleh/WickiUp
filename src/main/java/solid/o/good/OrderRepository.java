package solid.o.good;

/**
 * @author LinnykOleh
 */
public class OrderRepository {

	private IOrderSource source;

	public void setSource(IOrderSource source) {
		this.source = source;
	}

	public void load(int orderId) {
		// some business logic
		this.source.load(orderId);
	}

	public void save(Object order){
		// some business logic
		this.source.save(order);
	}

	public void update(Object order){
		// some business logic
		this.source.update(order);
	}

	public void delete(Object order){
		// some business logic
		this.source.delete(order);
	}
}
