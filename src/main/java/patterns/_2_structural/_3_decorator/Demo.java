package patterns._2_structural._3_decorator;

/**
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) {
		final Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));

		System.out.println(sandwich.make());
	}
}
