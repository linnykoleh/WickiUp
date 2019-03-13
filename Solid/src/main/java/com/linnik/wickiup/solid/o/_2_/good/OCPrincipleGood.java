package com.linnik.wickiup.solid.o._2_.good;

import java.util.HashMap;
import java.util.Map;

import com.linnik.wickiup.solid.o._2_.CardType;

public class OCPrincipleGood {

	private Map<CardType, Runnable> map = new HashMap<>();

	public void doWork(CardType cardType) {
		map.get(cardType).run();
	}

	public void registerCardTypeWorker(CardType cardType, Runnable runnable) {
		map.put(cardType, runnable);
	}

	public static void main(String[] args) {
		OCPrincipleGood ocPrinciple = new OCPrincipleGood();

		ocPrinciple.registerCardTypeWorker(CardType.VISA, () -> System.out.println("Work for visa"));
		ocPrinciple.registerCardTypeWorker(CardType.MASTERCARD, () -> System.out.println("Work for MasterCard"));

		ocPrinciple.doWork(CardType.VISA);
		ocPrinciple.doWork(CardType.MASTERCARD);
	}

}
