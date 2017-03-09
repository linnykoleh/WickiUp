package lafore.data_structures.linked_list.sorted_linked_list;

/**
 * @author LinnykOleh
 */
public class SortedListApp {

    public static void main(String[] args) {
        final SortedList sortedList = new SortedList();

        sortedList.insert(70);
        sortedList.insert(5);
        sortedList.insert(13);
        sortedList.insert(53);
        sortedList.insert(2);
        sortedList.insert(9);

        sortedList.displayList();

        sortedList.remove();
        sortedList.remove();

        sortedList.displayList();
    }
}
