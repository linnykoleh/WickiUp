package com.linnik.wickiup.laakmann.data_structures.hash_tables.open_addressing.linear_probing;

/**
 * @author LinnykOleh
 */
public class HashTableMain {

    /**
     * Hash Table
     *
     *   0      1      2      3      4      5      6      7      8      9
     *  ___    ___    ___    ___    ___    ___    ___    ___    ___    ___
     * |640|  |230|  |900|  |   |  |   |  | 15|  | 55|  |437|  |   |  | 19|
     * |___|  |___|  |___|  |___|  |___|  |___|  |___|  |___|  |___|  |___|
     *
     *
     *
     *      1. By value count hashCode (value %= arraySize).
     *                    - 640 % 10 = 0
     *                    - 15 % 10 = 5
     *                    - 230 % 10 = 0 (0 is busy next free index is 1)
     *                    - 19% 10 = 9
     *                    - 437 % 10 = 7
     *                    - 900 % 10 = 0 (0 is busy next free index is 2)
     *                    - 55 % 10 = 5 (5 is busy next free index is 6)
     *
     *      2. When counted `hashCode` the same then the value will be putted into next free cell.
     *      3. Counting hashCode guarantee that the index of cell will not be more than `arraySize`.
     *      4. In order to find value, the same count hashCode of value and return it.
     *      5. If we'd like to delete some value the same count hashCode of value and mark value inside sell as -1
     *
     * */
    public static void main(String[] args) {

        final HashTable hashTable = new HashTable(10);

        hashTable.insert(new DataItem(640));
        hashTable.insert(new DataItem(15));
        hashTable.insert(new DataItem(230));
        hashTable.insert(new DataItem(19));
        hashTable.insert(new DataItem(437));
        hashTable.insert(new DataItem(900));
        hashTable.insert(new DataItem(55));

        hashTable.displayTable();

        final DataItem dataItem = hashTable.find(2300);
        System.out.println(dataItem.getKey() + "\n");

        hashTable.delete(430);
        hashTable.delete(640);

        hashTable.displayTable();
    }
}
