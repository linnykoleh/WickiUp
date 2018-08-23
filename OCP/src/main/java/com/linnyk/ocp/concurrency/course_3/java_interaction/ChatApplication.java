package com.linnyk.ocp.concurrency.course_3.java_interaction;

public class ChatApplication {

	public static void main(String[] args) {
		final Chat chat = new Chat();

		new Answer(chat);
		new Question(chat);
	}
}