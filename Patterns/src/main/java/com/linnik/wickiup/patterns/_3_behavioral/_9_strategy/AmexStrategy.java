package com.linnik.wickiup.patterns._3_behavioral._9_strategy;

/**
 * @author LinnykOleh
 */
public class AmexStrategy extends ValidationStrategy{

    @Override
    public boolean isValid(CreditCard creditCard) {
        boolean isValid;

        isValid = creditCard.getNumber().startsWith("37") ||
                creditCard.getNumber().startsWith("34");

        if (isValid) {
            isValid = creditCard.getNumber().length() == 15;
        }
        if (isValid) {
            isValid = passesLuhn(creditCard.getCvv());
        }

        return isValid;
    }
}
