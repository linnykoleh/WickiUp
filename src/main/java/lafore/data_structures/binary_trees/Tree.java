package lafore.data_structures.binary_trees;

/**
 * @author LinnykOleh
 */
public class Tree {

    private Node root;

    public Node find(int iData){
        Node current = root;
        while (current.iData != iData){
            if(iData < current.iData){
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

    public void insert(int iData, double dData){
        final Node newNode = new Node(); // Создание нового узла
        newNode.iData = iData;     // Вставка данных
        newNode.dData = dData;

        if(root == null) {        // Корневой узел не существует
            root = newNode;
        } else {
            Node current = root;   // Начать с корневого узла
            Node parent;

            while(true) {          // (Внутренний выход из цикла)
                parent = current;
                if(iData < current.iData) {  // Двигаться налево?
                    current = current.leftChild;
                    if(current == null){     // Если достигнут конец цепочки вставить слева
                        parent.leftChild = newNode;
                        return;
                    }

                } else {                     // Или направо?
                    current = current.rightChild;
                    if(current == null) {    // Если достигнут конец цепочки вставить справа
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node miminum(){
        Node prev = root;
        Node current = root;
        while (current != null){
            current = prev;
            current = current.leftChild;
        }
        return prev;
    }

    public Node maximum(){
        Node prev = root;
        Node current = root;
        while (current != null){
            current = prev;
            current = current.rightChild;;
        }
        return prev;
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node localRoot) {
        if(localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        // поиск удаляемого узла
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.leftChild;
            }
            if (current == null) {
                return false;
            }
        }
        // поиск удаляемого узла


        // #1. Если узел не имеет потомков, он просто удаляется.
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        // #1.


        // #2. Удаление узла с одним потомком
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {  // Левый потомок родителя
                parent.leftChild = current.leftChild;
            } else {                   // Правый потомок родителя
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {    // Левый потомок родителя
                parent.leftChild = current.rightChild;
            } else {                    // Правый потомок родителя
                parent.rightChild = current.rightChild;
            }
        // #2.


        // #3. Удаляемый узел имеет двух потомков
        } else {
            // Поиск преемника для удаляемого узла (current)
            Node successor = getSuccessor(current);

            // Родитель current связывается с посредником
            if(current == root){
                root = successor;
            } else if(isLeftChild){
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }

            // Преемник связывается с левым потомком current
            successor.leftChild = current.leftChild;
        }
        // #3.


        return true;
    }

    //Поиск преемника
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // Переход к правому потомку пока остаются левые потомки

        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild; // Переход к левому потомку
        }

        // Если преемник не является правым потомком, создать связи между узлами
        if(successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

}
