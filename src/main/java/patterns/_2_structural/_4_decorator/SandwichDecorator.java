package patterns._2_structural._4_decorator;

/**
 * @author LinnykOleh
 */
public class SandwichDecorator implements Sandwich {

	protected Sandwich customSandwich;

	public SandwichDecorator(Sandwich customSandwich) {
		this.customSandwich = customSandwich;
	}

	@Override
	public String make() {
		return customSandwich.make();
	}
}
