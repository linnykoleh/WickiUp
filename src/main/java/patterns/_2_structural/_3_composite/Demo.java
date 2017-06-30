package patterns._2_structural._3_composite;

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

		System.out.println(mainMenu.toString());
	}
}
