package com.linnik.wickiup.patterns._1_creational._5_abstract_factory.factories;

import com.linnik.wickiup.patterns._1_creational._5_abstract_factory.CardType;
import com.linnik.wickiup.patterns._1_creational._5_abstract_factory.cards.AmexGoldCreditCard;
import com.linnik.wickiup.patterns._1_creational._5_abstract_factory.cards.AmexPlatinumCreditCard;
import com.linnik.wickiup.patterns._1_creational._5_abstract_factory.cards.CreditCard;

/**
 * @author LinnykOleh
 */
public class AmexFactory extends CreditCardFactory {

    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType){
            case GOLD: return new AmexGoldCreditCard();
            case PLATINUM: return new AmexPlatinumCreditCard();
            default: return null;
        }
    }
    
}
