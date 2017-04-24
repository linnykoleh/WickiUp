package lafore.algorithms.selection_sort;

/**
 * @author LinnykOleh
 */
public class ArraySelection {

    private int[] array;
    private int arraySize;

    public ArraySelection(int arraySize) {
        this.array = new int[arraySize];
    }

    public void insert(int value){
        if(arraySize < array.length){
            array[arraySize] = value;
        }
        arraySize++;
    }

    public void sort() {
        for (int out = 0; out < array.length; out++) {
            int min = out;
            for(int in = out + 1; in < array.length; in++){
                if(array[in] < array[min]){
                    min = in;
                }
            }
            swap(out, min);
        }
    }

    private void swap(int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public void display(){
        System.out.println();
        for(int v : array){
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
