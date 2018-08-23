package com.linnyk.akka.gk._3;

import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorRef;
import akka.actor.PoisonPill;
import akka.actor.Props;
import akka.actor.UntypedActor;


public class SumKernel extends UntypedActor {

	private final ActorRef master;
	private final List<Integer> state = new ArrayList<>();
	private ActorRef slave1;
	private ActorRef slave2;

	public SumKernel(ActorRef master) {
		this.master = master;
	}

	/**
	 * Концепция рекурсивного параллелизма.
	 *
	 * getContext() - получить ссылку на контейнер акторов (ActorSystem)
	 *
	 * */
	@Override
	public void onReceive(Object message) throws Throwable {
		if(message instanceof int[]) {
			final int from = ((int[]) message)[0]; // получили первый элемент массива
			final int to = ((int[]) message)[1];   // получили второй элемент массива

			if(to - from > 3){
				//делим половину на два актора
				(slave1 = getContext().actorOf(Props.create(SumKernel.class, getSelf()))).
						tell(new int[]{from, (from + to) >>> 1}, getSelf());

				(slave2 = getContext().actorOf(Props.create(SumKernel.class, getSelf()))).
						tell(new int[]{((from + to) >>> 1) + 1, to}, getSelf());
			}else {
				master.tell(calc(from, to), getSelf());
			}
		}else  if(message instanceof Integer){
			state.add((Integer)message);
			master.tell(state.get(0) + state.get(1), getSelf());

			//уничтожить акторы, тк их работа сделана
			slave1.tell(PoisonPill.getInstance(), getSelf());
			slave2.tell(PoisonPill.getInstance(), getSelf());
		}else{
			unhandled(message);
		}
	}

	private Integer calc(int from, int to){
		int result = 0;
		for(int k = from; k <= to; k++){
			result += k;
		}
		return result;
	}
}
