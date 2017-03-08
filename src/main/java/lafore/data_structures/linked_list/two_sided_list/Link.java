package lafore.data_structures.linked_list.two_sided_list;

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
