package com.linnik.wickiup.patterns._3_behavioral._9_strategy;

/**
 * @author LinnykOleh
 */
public class StrategyDemo {

    public static void main(String[] args) {
        final StrategyDemo strategyDemo = new StrategyDemo();
        strategyDemo.useStrategies();
    }

    public void useStrategies(){
        final CreditCard amexCard = new CreditCard(new AmexStrategy());
        amexCard.setNumber("379185883464283");
        amexCard.setDate("04/2020");
        amexCard.setCvv("123");

        System.out.println("Is Amex valid: " + amexCard.isValid());

        final CreditCard amexCard2 = new CreditCard(new AmexStrategy());
        amexCard2.setNumber("37929943181404123");
        amexCard2.setDate("04/2020");
        amexCard2.setCvv("123");

        System.out.println("Is Amex valid: " + amexCard2.isValid());

        final CreditCard visaCard = new CreditCard(new VisaStrategy());
        visaCard.setNumber("492994318140412343");
        visaCard.setDate("11/19");
        visaCard.setCvv("321");

        System.out.println("Is Visa valid: " + amexCard2.isValid());
    }
}
