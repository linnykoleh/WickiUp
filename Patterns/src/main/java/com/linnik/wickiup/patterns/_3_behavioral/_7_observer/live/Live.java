package com.linnik.wickiup.patterns._3_behavioral._7_observer.live;

import java.util.Observable;
import java.util.Observer;

/**
 * @author LinnykOleh
 */
public class Live {

	public static void main(String[] args) {
		final TwitterStream twitterStream = new TwitterStream();

		final Client client1 = new Client("Bryan");
		final Client client2 = new Client("Mark");

		twitterStream.addObserver(client1);
		twitterStream.addObserver(client2);

		twitterStream.someoneTweeted();
	}
}


/**
* Concrete subject
* */
class TwitterStream extends Observable{

	void someoneTweeted(){
		setChanged();
		notifyObservers();
	}
}

/**
 * Concrete subject
 */
class Client implements Observer {

	private String name;

	public Client(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Update " + this.name + "'s stream, someone tweeted something");
	}
}
