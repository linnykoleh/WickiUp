package com.linnyk.akka.gk._1;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class WorkerUp extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Throwable {
		if(message instanceof String){
			final String response = ((String) message).toUpperCase();

			final ActorRef sender = getSender(); // getSender() из UntypedActor
			final ActorRef self = getSelf();  // getSelf() из UntypedActor

			sender.tell(response, self);
		}else{
			unhandled(message); // unhandled() из UntypedActor
		}
	}
}
