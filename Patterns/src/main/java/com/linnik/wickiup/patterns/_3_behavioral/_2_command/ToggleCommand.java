package com.linnik.wickiup.patterns._3_behavioral._2_command;

/**
 * @author LinnykOleh
 */
public class ToggleCommand implements Command {

	private Light light;

	public ToggleCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.toggle();
	}
}
