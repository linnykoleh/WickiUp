package com.linnik.wickiup.patterns._3_behavioral._2_command;

/**
 * @author LinnykOleh
 */
public class OnCommand implements Command{

	private Light light;

	public OnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}
}
