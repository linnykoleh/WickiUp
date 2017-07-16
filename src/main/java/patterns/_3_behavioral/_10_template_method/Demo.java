package patterns._3_behavioral._10_template_method;

/**
 * @author LinnykOleh
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("Web order: ");

        final OrderTemplate webOrder = new WebOrder();
        webOrder.processOrder();

        System.out.println("\nStore order: ");

        final OrderTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder();
    }
}
