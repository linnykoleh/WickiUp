package com.linnik.wickiup.patterns._3_behavioral._10_template_method.live;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LinnykOleh
 */
public class Live {

    public static void main(String[] args) {
        final List<Person> persons = new ArrayList<>();

        persons.add(new Person("Bryan", 35));
        persons.add(new Person("Mark", 25));
        persons.add(new Person("Chris", 30));

        System.out.println("Before sorting: " + persons);

        Collections.sort(persons);

        System.out.println("After sorting: " + persons);
    }
}

class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        if(this.age > o.getAge()){
            return 1;
        }
        if(this.age < o.getAge()){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

