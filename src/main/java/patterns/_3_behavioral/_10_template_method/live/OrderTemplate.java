package patterns._3_behavioral._10_template_method.live;

/**
 * @author LinnykOleh
 */
public abstract class OrderTemplate {

    public boolean isGift;

    public final void wrapGift(){
        System.out.println("Gift was wrapped");
    }

    public final void processOrder(){
        doCheckout();
        doPayment();
        if(isGift){
            wrapGift();
        }else{
            doReceipt();
        }
        doDelivery();
    }

    public abstract void doCheckout();

    public abstract void doPayment();

    public abstract void doReceipt();

    public abstract void doDelivery();

}
