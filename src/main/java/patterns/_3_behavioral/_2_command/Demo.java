package patterns._3_behavioral._2_command;

/**
 * Client
 *
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) {
		final Light light = new Light();
		final Switch lightSwitch = new Switch();

		final Command command = new OnCommand(light);

		lightSwitch.storeAndExecute(command);
	}
}
