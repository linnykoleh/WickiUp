package lafore.data_structures.linked_lists.two_sided_linked_list;

/**
 * @author LinnykOleh
 */
public class Link {

    public double dData;
    public Link next;

    public Link(double dData) {
        this.dData = dData;
        this.next = null;
    }

    public void displayLink(){
        System.out.println("{dData: " + this.dData + " }");
    }
}
