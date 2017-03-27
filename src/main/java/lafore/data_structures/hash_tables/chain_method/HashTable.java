package lafore.data_structures.hash_tables.chain_method;

/**
 * @author LinnykOleh
 */
public class HashTable {

    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new SortedList[arraySize];
        for(int i = 0; i < arraySize; i++){
            hashArray[i] = new SortedList();
        }
    }

    public void displayTable(){
        for(int i = 0; i < arraySize; i++){
            System.out.print(i + ": ");
            hashArray[i].displayList();
        }
        System.out.println(" ");
    }

    private int hashFunc(int key){
        return key % arraySize;
    }

    public void insert(int key){
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(new Link(key));
    }

    public void delete(int key){
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key){
        int hashVal = hashFunc(key);
        final Link link = hashArray[hashVal].find(key);
        return link;
    }

}
