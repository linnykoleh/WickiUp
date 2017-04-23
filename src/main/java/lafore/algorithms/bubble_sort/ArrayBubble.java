package lafore.algorithms.bubble_sort;

/**
 * @author LinnykOleh
 */
public class ArrayBubble {

    private int[] array;
    private int size;

    public ArrayBubble(int arraySize) {
        this.array = new int[arraySize];
    }

    public void insert(int value){
        if(size < array.length){
            array[size] = value;
        }
        size++;
    }

    public void sort() {
        for (int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]){
                    swap(i, j);
                }
            }
        }
    }

    private void swap(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void display(){
        System.out.println();
        for(int v : array){
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
