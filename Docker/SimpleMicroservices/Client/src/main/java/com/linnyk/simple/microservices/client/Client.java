package com.linnyk.simple.microservices.client;

import java.time.LocalDateTime;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		while (true){
			Thread.sleep(1000);
			System.out.println("Hello Docker " + LocalDateTime.now());
		}
	}
}
