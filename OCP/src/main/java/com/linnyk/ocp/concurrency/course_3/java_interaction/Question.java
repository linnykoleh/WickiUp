package com.linnyk.ocp.concurrency.course_3.java_interaction;

public class Question implements Runnable {

	private Chat chat;
	private String[] questions = { "Hi", "How are you ?", "I am also doing fine!" };

	public Question(Chat m1) {
		this.chat = m1;
		new Thread(this, "question").start();
	}

	public void run() {
		for (int i = 0; i < questions.length; i++) {
			chat.question(questions[i]);
		}
	}
}