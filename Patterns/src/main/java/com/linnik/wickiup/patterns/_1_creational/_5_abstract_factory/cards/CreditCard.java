package com.linnik.wickiup.patterns._1_creational._5_abstract_factory.cards;

/**
 * AbstractProduct
 *
 * @author LinnykOleh
 */
public abstract class CreditCard {

    private int cardNumberLength;
    private int csvLength;

    public int getCardNumberLength() {
        return cardNumberLength;
    }

    public void setCardNumberLength(int cardNumberLength) {
        this.cardNumberLength = cardNumberLength;
    }

    public int getCsvLength() {
        return csvLength;
    }

    public void setCsvLength(int csvLength) {
        this.csvLength = csvLength;
    }


}
