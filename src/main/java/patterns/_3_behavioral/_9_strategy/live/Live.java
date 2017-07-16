package patterns._3_behavioral._9_strategy.live;

import java.util.*;

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

        Collections.sort(persons, (o1, o2) -> {
            if(o1.getAge() > o2.getAge()){
                return 1;
            }
            if(o1.getAge() < o2.getAge()){
                return -1;
            }
            return 0;
        });
        System.out.println("After sorting by age" + persons);

        Collections.sort(persons, Comparator.comparing(Person::getName));

        System.out.println("After sorting by name" + persons);
    }
}

class Person{

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
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
