package com.linnyk.akka.actors;

import akka.actor.UntypedActor;
import com.linnyk.akka.beans.User;

public class UserUntypedActor extends UntypedActor {

    public void onReceive(Object message) throws Throwable {
        if(message instanceof String){
            System.out.println(message);
        }else if(message instanceof User){
            System.out.println(message);
        }
    }
}
