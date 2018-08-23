package com.linnyk.akka.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.linnyk.akka.beans.User;

public class AkkaMain {

    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("MySystem");
        final ActorRef myActor = system.actorOf(Props.create(MyUntypedActor.class), "myactor");
        final ActorRef userActor = system.actorOf(Props.create(UserUntypedActor.class), "useractor");

        myActor.tell("Message", ActorRef.noSender());

        userActor.tell("Message User", ActorRef.noSender());
        userActor.tell(new User("name", "username"), ActorRef.noSender());
    }
}

