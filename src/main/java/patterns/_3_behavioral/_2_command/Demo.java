package patterns._3_behavioral._2_command;

import java.util.ArrayList;
import java.util.List;

/**
 * Client
 *
 * @author LinnykOleh
 */
public class Demo {

	public static void main(String[] args) {
		final Light bedroomLight = new Light();
		final Light kitchenLight = new Light();
		final Switch lightSwitch = new Switch();

		final Command command = new ToggleCommand(bedroomLight);

		lightSwitch.storeAndExecute(command);
		lightSwitch.storeAndExecute(command);
		lightSwitch.storeAndExecute(command);

		final List<Light> lights = new ArrayList<>();
		lights.add(bedroomLight);
		lights.add(kitchenLight);

		final Command allLightsCommand = new AllLightsCommand(lights);

		lightSwitch.storeAndExecute(allLightsCommand);

	}
}
