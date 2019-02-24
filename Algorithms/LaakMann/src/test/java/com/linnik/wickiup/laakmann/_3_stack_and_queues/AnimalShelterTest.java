package com.linnik.wickiup.laakmann._3_stack_and_queues;

import org.junit.Assert;
import org.junit.Test;

public class AnimalShelterTest {

    @Test
    public void test() {
        AnimalShelter animalShelter = new AnimalShelter();

        animalShelter.enqueue(new Dog("dog1"));
        animalShelter.enqueue(new Cat("cat1"));
        animalShelter.enqueue(new Dog("dog2"));
        animalShelter.enqueue(new Cat("cat2"));
        animalShelter.enqueue(new Dog("dog3"));
        animalShelter.enqueue(new Cat("cat3"));

        Animal animal = animalShelter.dequeueAny();

        Assert.assertTrue(animal instanceof Dog);
        Assert.assertEquals("dog1", animal.name);

        Animal animal1 = animalShelter.dequeueAny();

        Assert.assertTrue(animal1 instanceof Cat);
        Assert.assertEquals("cat1", animal1.name);
    }
}
