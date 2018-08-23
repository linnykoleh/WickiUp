package com.linnyk.akka.actors;

import akka.actor.ActorSelection;
import akka.actor.UntypedActor;

public class MyUntypedActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String) {
            System.out.println(message);
        } else {
            unhandled(message);
        }
    }

    private void toFindActor(){
        final ActorSelection myActor = super.getContext().actorSelection("myactor");
        System.out.println(myActor);
    }

}
