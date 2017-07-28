package com.linnik.wickiup.patterns._3_behavioral._7_observer;

/**
 * @author LinnykOleh
 */
public class PhoneClient extends Observer{

	public PhoneClient(Subject subject) {
		super.subject = subject;
		subject.attach(this);
	}

	public void addMessage(String message) {
		subject.setState(message + " - sent from phone");
	}

	@Override
	public void update() {
		System.out.println("Phone Stream: " + subject.getState());
	}
}
