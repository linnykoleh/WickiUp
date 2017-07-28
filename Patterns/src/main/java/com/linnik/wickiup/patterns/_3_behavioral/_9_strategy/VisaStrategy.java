package com.linnik.wickiup.patterns._3_behavioral._9_strategy;

/**
 * @author LinnykOleh
 */
public class VisaStrategy extends ValidationStrategy{

    @Override
    public boolean isValid(CreditCard creditCard) {
        boolean isValid;

        isValid = creditCard.getNumber().startsWith("4");

        if (isValid) {
            isValid = creditCard.getNumber().length() == 16;
        }
        if (isValid) {
            isValid = passesLuhn(creditCard.getCvv());
        }

        return isValid;
    }
}
