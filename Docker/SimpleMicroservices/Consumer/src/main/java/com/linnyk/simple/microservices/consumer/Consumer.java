package com.linnyk.simple.microservices.consumer;

import java.awt.Image;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;

public class Consumer {

	private static final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {
		while (true){
			Thread.sleep(1000);
			System.out.println("Hello Docker " + LocalDateTime.now());
			sendGet();
		}
	}

	private static void sendGet() throws Exception {
		String url = "http://dnmonster:8080/monster/test?size=80";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		final Image image = ImageIO.read(obj);
		System.out.println(image);

	}
}
