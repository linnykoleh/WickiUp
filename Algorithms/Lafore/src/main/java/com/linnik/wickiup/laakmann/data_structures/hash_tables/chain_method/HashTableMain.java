package com.linnik.wickiup.laakmann.data_structures.hash_tables.chain_method;

/**
 * @author LinnykOleh
 */
public class HashTableMain {

    /**
     *  1. Count the hashCode of particular value:
     *               - 538 % 5 = 3
     *               - 412 % 5 = 2
     *               - 73 % 5 =  3
     *               - 12 % 5 =  2
     *               - 120 % 5 = 0
     *               - 44 % 5 =  4
     *               - 10 % 5 =  0
     *               - 623 % 5 = 3
     *               - 90 % 5 =  0
     *               - 45 % 5 =  0
     *               - 12 % 5 =  2
     *               - 98 % 5 =  3
     *               - 42 % 5 =  2
     *               - 100 % 5 = 0
     *               - 111 % 5 = 1
     *               - 201 % 5 = 1
     *  2. `HashCode` gives as an index of array where to put a value (return key % arraySize).
     *  3. If `hashCode` is the same like (90 % 5) = 0, (45 % 5) = 0, (120 % 5) = 0 then is using a `LinkedList`
     *     and value inserted like in a sorted linked list  `45 -> 90 -> 120 -> `
     *
     *  4. Result
     *
     *      0: 10 -> 45 -> 90 -> 100 -> 120 -> null
     *      1: 111 -> 201 -> null
     *      2: 12 -> 12 -> 42 -> 412 -> null
     *      3: 73 -> 98 -> 538 -> 623 -> null
     *      4: 44 -> null
     *
     */
    public static void main(String[] args) {
        final HashTable hashTable = new HashTable(5);

        hashTable.insert(538);
        hashTable.insert(412);
        hashTable.insert(73);
        hashTable.insert(12);
        hashTable.insert(120);
        hashTable.insert(44);
        hashTable.insert(10);
        hashTable.insert(623);
        hashTable.insert(90);
        hashTable.insert(45);
        hashTable.insert(12);
        hashTable.insert(98);
        hashTable.insert(42);
        hashTable.insert(100);
        hashTable.insert(111);
        hashTable.insert(201);

        hashTable.displayTable();

        hashTable.delete(100);
        hashTable.delete(73);

        hashTable.displayTable();
    }
}
