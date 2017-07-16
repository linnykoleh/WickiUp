package patterns._3_behavioral._11_visitor;

import java.util.List;

/**
 * @author LinnykOleh
 */
public class AtvPartsShippingVisitor implements AtvPartVisitor {

    private double shippingAmount = 0;

    @Override
    public void visit(Fender fender) {
        System.out.println("Fenders are light and cheap to ship");
        shippingAmount += 3;
    }

    @Override
    public void visit(Oil oil) {
        System.out.println("Oil is hazardous and has a fee to ship");
        shippingAmount += 9;
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Wheels are bulky and expensive to sheep");
        shippingAmount += 15;
    }

    @Override
    public void visit(PartsOrder partsOrder) {
        System.out.println("If they bought more than 3 things we will give then a discount");
        final List<AtvPart> parts = partsOrder.getParts();
        if(parts.size() > 3){
            shippingAmount -= 5;
        }
        System.out.println("Shipping amount is: " + shippingAmount);
    }
}
