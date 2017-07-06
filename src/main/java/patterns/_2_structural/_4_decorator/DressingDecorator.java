package patterns._2_structural._4_decorator;

/**
 * @author LinnykOleh
 */
public class DressingDecorator extends SandwichDecorator {

	public DressingDecorator(Sandwich customSandwich) {
		super(customSandwich);
	}

	@Override
	public String make() {
		return customSandwich.make() + addDressing();
	}

	private String addDressing() {
		return " + mustard";
	}
}
