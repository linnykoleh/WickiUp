package com.linnik.wickiup.patterns._1_creational._5_abstract_factory;

import patterns._1_creational._5_abstract_factory.cards.CreditCard;
import patterns._1_creational._5_abstract_factory.factories.CreditCardFactory;

/**
 * @author LinnykOleh
 */
public class Demo {

    public static void main(String[] args) {

        CreditCardFactory factory = CreditCardFactory.getCreditCardFactory(700);
        CreditCard creditCard = factory.getCreditCard(CardType.GOLD);
        System.out.println(creditCard);

        factory = CreditCardFactory.getCreditCardFactory(600);
        creditCard = factory.getCreditCard(CardType.PLATINUM);
        System.out.println(creditCard);

    }

}
