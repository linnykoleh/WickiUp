package lafore.data_structures.binary_trees;

/**
 * @author LinnykOleh
 */
public class TreeApp {

    public static void main(String[] args) {

        final Tree tree = new Tree();

        tree.insert(50, 1.5);
        tree.insert(25, 1.7);
        tree.insert(75, 1.9);

        final Node node = tree.find(25);

        if(node != null) {
            node.displayNode();
        }
    }
}
