package com.linnik.wickiup.solid.o._2_.bad;

import com.linnik.wickiup.solid.o._2_.CardType;

public class OCPrincipleBad {

	public void doWork(CardType cardType) {
		switch (cardType) {
			case VISA:
				doWorkForVisa();
			case MASTERCARD:
				doWorkForMasterCard();
		}
	}

	private void doWorkForVisa() {
		System.out.println("Work for visa");
	}

	private void doWorkForMasterCard() {
		System.out.println("Work for MasterCard");
	}

	public static void main(String[] args) {
		OCPrincipleBad ocPrinciple = new OCPrincipleBad();

		ocPrinciple.doWork(CardType.VISA);
		ocPrinciple.doWork(CardType.MASTERCARD);
	}
}
