package lafore.data_structures.hash_tables.open_addressing.double_hashing;

/**
 * @author LinnykOleh
 */
public class HashTableMain {

    public static void main(String[] args) {
        final HashTable hashTable = new HashTable(13);

        hashTable.insert(42);
        hashTable.insert(319);
        hashTable.insert(943);
        hashTable.insert(1);
        hashTable.insert(10);
        hashTable.insert(33);
        hashTable.insert(43);
        hashTable.insert(333);
        hashTable.insert(983);

        hashTable.displayTable();

        final DataItem dataItem = hashTable.find(1);

        System.out.println(dataItem.getKey() + "\n");

        hashTable.delete(319);
        hashTable.delete(33);

        hashTable.displayTable();
    }
}
