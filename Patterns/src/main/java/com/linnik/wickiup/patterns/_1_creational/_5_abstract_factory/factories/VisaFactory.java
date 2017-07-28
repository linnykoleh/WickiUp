package com.linnik.wickiup.patterns._1_creational._5_abstract_factory.factories;

import com.linnik.wickiup.patterns._1_creational._5_abstract_factory.CardType;
import com.linnik.wickiup.patterns._1_creational._5_abstract_factory.cards.CreditCard;
import com.linnik.wickiup.patterns._1_creational._5_abstract_factory.cards.VisaGoldCreditCard;
import com.linnik.wickiup.patterns._1_creational._5_abstract_factory.cards.VisaPlatinumCreditCard;

/**
 * @author LinnykOleh
 */
public class VisaFactory extends CreditCardFactory {

    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType){
            case GOLD: return new VisaGoldCreditCard();
            case PLATINUM: return new VisaPlatinumCreditCard();
            default: return null;
        }
    }
}
