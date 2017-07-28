package com.linnik.wickiup.patterns._2_structural._4_decorator;

/**
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) {
		final Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));
		//                             mustard              turkey             bread

		System.out.println(sandwich.make());

		/*
				bread + turkey + mustard
		 */
	}
}
