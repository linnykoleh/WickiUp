package patterns._1_creational._5_abstract_factory.factories;

import patterns._1_creational._5_abstract_factory.CardType;
import patterns._1_creational._5_abstract_factory.cards.CreditCard;
import patterns._1_creational._5_abstract_factory.cards.VisaGoldCreditCard;
import patterns._1_creational._5_abstract_factory.cards.VisaPlatinumCreditCard;

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
