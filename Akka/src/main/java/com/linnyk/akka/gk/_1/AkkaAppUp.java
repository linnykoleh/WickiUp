package com.linnyk.akka.gk._1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AkkaAppUp {

	/**
	 * ActorSystem - контейнер акторов
	 * ActorSystem system = ActorSystem.create("demo");
	 *
	 * system.actorOf(Props.create(Class clazz)) - создать актор внутри контейнера
	 *
	 * tell(Object, sender) - передача сообщения
	 *
	 * system.shutdown() - выключить контейнер акторов
	 *
	 * MailBox - очередь сообщений (неблокирующая очередь)
	 *
	 * -------------------------------------------------
	 *
	 * Actor - объект с одним методом onReceive(Object)
	 *
	 * Когда делаем tell, сообщение помещается в MailBox (очередь)
	 *
	 *
	 *
	 *                                  |-------------------------|
	 *             _______________      |             |ActorSystem|
	 * tell -|     |   MailBox   |      |              -----------|
	 *       |     |-------------|      |             			  |
	 * tell ---->  | | | | | | | |  --->| onReceive()             |
	 *       |     |-------------|      |                         |
	 * tell -|                          |                         |
	 *                                  |                         |
	 *                                  |-------------------------|
	 *
	 * */

	public static void main(String[] args) {
		final ActorSystem system = ActorSystem.create("demo");

		final ActorRef worker = system.actorOf(Props.create(WorkerUp.class), "worker");
		final ActorRef callback = system.actorOf(Props.create(Callback.class), "callback");

		worker.tell("Hello", callback);

		system.shutdown();
	}
}
