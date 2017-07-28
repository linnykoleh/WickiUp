package com.linnik.wickiup.patterns._2_structural._3_composite;

/**
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) {
		final Menu mainMenu = new Menu("Main", "/main");

		final MenuItem safetyMenuItem = new MenuItem("Safety", "/safety");
		mainMenu.add(safetyMenuItem);

		final Menu clamsSubMenu = new Menu("Claims", "/claims");
		mainMenu.add(clamsSubMenu);

		final MenuItem personalClaimsMenu = new MenuItem("Personal Claim", "/personalClaims");
		clamsSubMenu.add(personalClaimsMenu);

		final MenuItem privateClaimsMenu = new MenuItem("Private Claim", "/privateClaims");
		clamsSubMenu.add(privateClaimsMenu);

		System.out.println(mainMenu.toString());

		/*

			Main: /main
			... Safety: /safety
			Claims: /claims
			... Personal Claim: /personalClaims
			... Private Claim: /privateClaims

		*/
	}
}
