package com.linnyk.akka.gk._1;

import akka.actor.UntypedActor;


public class Callback extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Throwable {
		if(message instanceof String){
			System.out.println((String) message);
		}else{
			unhandled(message);
		}

	}
}
