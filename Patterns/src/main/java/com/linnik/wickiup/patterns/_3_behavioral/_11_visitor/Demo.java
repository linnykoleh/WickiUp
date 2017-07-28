package com.linnik.wickiup.patterns._3_behavioral._11_visitor;

/**
 * @author LinnykOleh
 */
public class Demo {

    public static void main(String[] args) {
        final PartsOrder order = new PartsOrder();

        order.addPart(new Wheel());
        order.addPart(new Fender());
        order.addPart(new Oil());

        order.accept(new AtvPartsShippingVisitor());
        order.accept(new AtvPartsDisplayVisitor());
    }
}
