package lafore.data_structures.hash_tables.hash_set;

import lafore.data_structures.hash_tables.hash_set.objects.Animal;

import java.util.HashSet;

/**
 * @author LinnykOleh
 */
public class HashSetTest {

    public static void main(String[] args) {
        final HashSet<Animal> hashSet = new HashSet<>();

        hashSet.add(new Animal("Cat"));
        hashSet.add(new Animal("Dog"));

        System.out.println(hashSet.size());

        hashSet.add(new Animal("Cat"));

        System.out.println(hashSet.size());

        hashSet.iterator();
        hashSet.stream();
    }
}
