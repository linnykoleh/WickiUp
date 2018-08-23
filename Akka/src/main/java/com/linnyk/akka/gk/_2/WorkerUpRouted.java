package com.linnyk.akka.gk._2;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class WorkerUpRouted extends UntypedActor{

	@Override
	public void onReceive(Object message) throws Throwable {

		if(message instanceof String){
			final String response = ((String) message).toUpperCase();

			final ActorRef sender = getSender();
			final ActorRef self = getSelf();

			sender.tell(response, self);
			while(true); // прибить поток(актор)
		}else{
			unhandled(message);
		}

	}
}
