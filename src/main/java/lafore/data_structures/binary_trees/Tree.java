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

    public void delete(int id){

    }
}
