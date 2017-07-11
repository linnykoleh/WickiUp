package patterns._3_behavioral._4_iterator;

import java.util.*;

/**
 * @author LinnykOleh
 */
public class Demo {

    public static void main(String[] args) {

        final BikeRepository repo = new BikeRepository();

        repo.addBike("Cervelo");
        repo.addBike("Scott");
        repo.addBike("Fujt");

        final Iterator<String> bikeIterator = repo.iterator();

        while (bikeIterator.hasNext()){
            System.out.println(bikeIterator.next());
        }

        for (String bike : repo) { // used Iterator
            System.out.println(bike);
        }
    }
}
