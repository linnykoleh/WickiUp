package com.linnyk.akka.gk._2;

import java.util.Scanner;

import com.linnyk.akka.gk._1.Callback;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.SmallestMailboxPool;

public class AppUpRouted {

	/**
	 *
	 *  SmallestMailboxPool(int число потоков) - лоад - балансер
	 *
	 * */

	public static void main(String[] args) {

		ActorSystem system = ActorSystem.create("demo");

		final ActorRef router = system.actorOf(new SmallestMailboxPool(3).props(Props.create(WorkerUpRouted.class)), "router");
		final ActorRef callback = system.actorOf(Props.create(Callback.class), "callback");

		final Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if("exit".equals(line)){
				system.shutdown();
				return;
			}
			router.tell(line, null);
		}

		router.tell("Message", callback);

	}
}
