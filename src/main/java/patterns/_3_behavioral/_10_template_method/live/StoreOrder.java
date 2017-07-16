package patterns._3_behavioral._10_template_method.live;

/**
 * @author LinnykOleh
 */
public class StoreOrder extends OrderTemplate{

    @Override
    public void doCheckout() {
        System.out.println("Ring up items from cart");
    }

    @Override
    public void doPayment() {
        System.out.println("Process payment with Card");
    }

    @Override
    public void doReceipt() {
        System.out.println("Print receipt");
    }

    @Override
    public void doDelivery() {
        System.out.println("Bog items at counter");
    }
}
