package lafore.data_structures.binary_trees;

/**
 * @author LinnykOleh
 */
public class Tree {

    private Node root;

    public Node find(int key){
        Node current = root;
        while (current.iData != key){
            if(key < current.iData){
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }
            if(current == null){
                return null;
            }
        }
        return current;
    }

    public void insert(int id, double dData){

    }

    public void delete(int id){

    }
}
