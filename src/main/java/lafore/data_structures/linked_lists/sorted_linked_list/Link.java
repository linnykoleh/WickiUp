package lafore.data_structures.linked_lists.sorted_linked_list;

/**
 * @author LinnykOleh
 */
public class Link {

    public int iData;
    public Link next;

    public Link(int iData) {
        this.iData = iData;
        this.next = null;
    }

    public void displayLink(){
        System.out.print(" " + iData);
    }
}
