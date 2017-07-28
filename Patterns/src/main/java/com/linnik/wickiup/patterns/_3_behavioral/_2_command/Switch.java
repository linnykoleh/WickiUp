package com.linnik.wickiup.patterns._3_behavioral._2_command;

/**
 * Invoker
 *
 * @author LinnykOleh
 */
public class Switch {

	public void storeAndExecute(Command command){
		command.execute();
	}
}
