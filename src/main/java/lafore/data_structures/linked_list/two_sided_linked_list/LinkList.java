package lafore.data_structures.linked_list.two_sided_linked_list;

/**
 * @author LinnykOleh
 */
public class LinkList {

    private Link first;
    private Link last;

    private boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(double dData){
        final Link newLink = new Link(dData);
        if(isEmpty()) {
           last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(double dData){
        final Link newLink = new Link(dData);
        if(isEmpty()) {
            first = newLink;
        }else{
            last.next = newLink;
        }
    }

    public Link deleteFirst(){
        if(!isEmpty()){
            Link tmp = first;
            first = first.next;
            return tmp;
        }
        return first;
    }

    public void displayList(){
        System.out.println();
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
    }


}
