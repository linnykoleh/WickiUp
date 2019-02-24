package com.linnik.wickiup.laakmann._3_stack_and_queues;

import java.util.LinkedList;

/**
 * ===========================================================================================================
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
 * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
 * that type). They cannot select which specific animal they would like. Create the data structures to
 * maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 * and dequeueCat. You may use the built in Linkedlist data structure.
 * ============================================================================================================
 */
public class AnimalShelter {

    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();

    private int order = 0; // acts as timestamp

    public void enqueue(Animal a) {
        /* Order is used as a sort of timestamp, so that we can
           compare the insertion order of a dog to a cat. */
        a.order = order;
        order++;

        if (a instanceof Dog) {
            dogs.addLast((Dog) a);
        } else if (a instanceof Cat) {
            cats.addLast((Cat) a);
        }
    }

    public Animal dequeueAny() {
        /* Look at tops of dog and cat queues, and pop the queue with the oldest value. */
        if (dogs.size() == 0) {
            return cats.poll();
        } else if (cats.size() == 0) {
            return dogs.poll();
        }

        Dog dog = dogs.peek(); // Retrieves, but does not remove, the first element of this list.
        Cat cat = cats.peek(); // Retrieves, but does not remove, the first element of this list.
        if (dog.isOlderThan(cat)) {
            return dogs.poll(); //Retrieves and removes the first element of this list
        } else {
            return cats.poll();  //Retrieves and removes the first element of this list
        }
    }
}

abstract class Animal {

    int order;
    String name;

    public Animal(String name) {
        this.name = name;
    }

    /* Compare orders of animals to return the older item. */
    public boolean isOlderThan(Animal animal) {
        return this.order < animal.order;
    }
}

class Dog extends Animal {
    public Dog(String n) {
        super(n);
    }
}

class Cat extends Animal {
    public Cat(String n) {
        super(n);
    }
}
