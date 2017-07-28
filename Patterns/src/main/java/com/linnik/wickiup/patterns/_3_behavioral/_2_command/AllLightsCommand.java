package com.linnik.wickiup.patterns._3_behavioral._2_command;

import java.util.List;

/**
 * @author LinnykOleh
 */
public class AllLightsCommand implements Command{

	private List<Light> lights;

	public AllLightsCommand(List<Light> lights) {
		this.lights = lights;
	}

	@Override
	public void execute() {
		lights.forEach(light -> {
			if(light.isOn()){
				light.toggle();
			}
		});
	}
}
