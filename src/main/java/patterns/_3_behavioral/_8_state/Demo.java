package patterns._3_behavioral._8_state;

/**
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) {

		final Fan fan = new Fan();

		System.out.println(fan);
		fan.pullChain();

		System.out.println(fan);
		fan.pullChain();

		System.out.println(fan);
		fan.pullChain();

		System.out.println(fan);
		fan.pullChain();

		System.out.println(fan);
		fan.pullChain();
	}
}
