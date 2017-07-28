package com.linnik.wickiup.patterns._3_behavioral._2_command;

/**
 * Receiver
 *
 * @author LinnykOleh
 */
public class Light {

	private boolean isOn = false;

	public boolean isOn(){
		return isOn;
	}

	public void toggle(){
		if(isOn){
			off();
			isOn = false;
		}else{
			on();
			isOn = true;
		}
	}

	public void on(){
		System.out.println("Light switched on.");
	}

	public void off(){
		System.out.println("Light switched off.");
	}

}
