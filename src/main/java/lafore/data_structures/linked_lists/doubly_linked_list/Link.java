package lafore.data_structures.linked_lists.doubly_linked_list;

/**
 * @author LinnykOleh
 */
public class Link {

    public int iData;
    public Link next;
    public Link previous;

    public Link(int iData) {
        this.iData = iData;
        this.next = null;
        this.previous = null;
    }

    public void displayLink(){
        System.out.println(" " + iData);
    }
}
