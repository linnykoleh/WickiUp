package com.linnik.wickiup.patterns._2_structural._6_flyweight;

/**
 * @author LinnykOleh
 */
public class Demo {

    public static void main(String[] args) {
        final InventorySystem inventorySystem = new InventorySystem();

        inventorySystem.takeOrder("Roomba", 221);
        inventorySystem.takeOrder("Bose phone", 361);
        inventorySystem.takeOrder("Samsung TV", 432);
        inventorySystem.takeOrder("Roomba", 412);
        inventorySystem.takeOrder("Bose phone", 821);
        inventorySystem.takeOrder("Samsung TV", 234);

        inventorySystem.process();

        System.out.println(inventorySystem.report());
    }
}
