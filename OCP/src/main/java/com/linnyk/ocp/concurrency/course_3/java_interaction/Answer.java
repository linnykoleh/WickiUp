package com.linnyk.ocp.concurrency.course_3.java_interaction;

public class Answer implements Runnable {

	private Chat chat;
	private String[] answers = { "Hi", "I am good, what about you?", "Great!" };

	public Answer(Chat chat) {
		this.chat = chat;
		new Thread(this, "answer").start();
	}

	public void run() {
		for (int i = 0; i < answers.length; i++) {
			chat.answer(answers[i]);
		}
	}
}
