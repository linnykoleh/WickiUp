package com.linnik.wickiup.patterns._3_behavioral._7_observer;

/**
 * @author LinnykOleh
 */
public class TabletClient extends Observer{

	public TabletClient(Subject subject){
		this.subject = subject;
		subject.attach(this);
	}

	public void addMessage(String message) {
		subject.setState(message + " - sent from tablet");
	}

	@Override
	public void update() {
		System.out.println("Tablet Stream: " + subject.getState());
	}
}
