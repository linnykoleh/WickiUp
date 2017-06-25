package patterns._1_creational._5_abstract_factory.factories;

import patterns._1_creational._5_abstract_factory.CardType;
import patterns._1_creational._5_abstract_factory.cards.CreditCard;
import patterns._1_creational._5_abstract_factory.validators.Validator;

/**
 * AbstractFactory
 *
 * @author LinnykOleh
 */
public abstract class CreditCardFactory {

    public static CreditCardFactory getCreditCardFactory(int creditScore){
        if(creditScore > 650){
            return new AmexFactory();
        }else{
            return new VisaFactory();
        }
    }

    public abstract CreditCard getCreditCard(CardType cardType);

    public abstract Validator getValidator(CardType cardType);

}
