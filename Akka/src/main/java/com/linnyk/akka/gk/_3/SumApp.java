package com.linnyk.akka.gk._3;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.linnyk.akka.gk._1.Callback;

public class SumApp {

	/**
	*
	*  final ActorRef kernel = system.actorOf(Props.create(SumKernel.class, callback), "sumkernel");
	*
	*  callback - попадет в конструктор актора, когда тот будет создаваться
	*
	* */
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("demoSum");

		final ActorRef callback = system.actorOf(Props.create(Callback.class), "callback");
		final ActorRef kernel = system.actorOf(Props.create(SumKernel.class, callback), "sumkernel");

		kernel.tell(new int[]{0,10}, ActorRef.noSender());
	}
}
