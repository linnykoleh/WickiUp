package patterns._2_structural._5_flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author LinnykOleh
 */
public class InventorySystem {

    private final Catalog catalog = new Catalog();
    private final List<Order> orders = new CopyOnWriteArrayList<>();

    public void takeOrder(String itemName, int orderNumber) {
        final Item item = catalog.lookUp(itemName);
        final Order order = new Order(orderNumber, item);
        orders.add(order);
    }

    public void process(){
        for(Order order : orders){
            order.processOrder();
            orders.remove(order);
        }
    }

    public String report(){
        return "Total Item objects: " + catalog.totalItemsMade();
    }
}
