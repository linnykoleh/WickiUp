package com.linnik.wickiup.patterns._3_behavioral._7_observer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author LinnykOleh
 */
public class MessageStream extends Subject{

	private Deque<String> messageHistory = new ArrayDeque<>();

	@Override
	public void setState(String message) {
		messageHistory.add(message);
		this.notifyObservers();
	}

	@Override
	public String getState() {
		return messageHistory.getFirst();
	}
}
