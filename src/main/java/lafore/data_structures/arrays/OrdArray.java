package lafore.data_structures.arrays;

/**
 * @author LinnykOleh
 */
public class OrdArray {

	private int[] array;
	private int nItems;

	public OrdArray(int[] array) {
		this.array = array;
		this.nItems = 0;
	}

	public void insert(int element){
		int j;
		for(j=0; j < nItems; j++)         // Определение позиции вставки
			if(array[j] > element)        // (линейный поиск)
				break;

		for(int k = nItems; k > j; k--)   // Перемещение последующих элементов
			array[k] = array[k-1];

		array[j] = element;               // Вставка
		nItems++;
	}

	public int getSize(){
		return nItems;
	}

	public void print(){
		for(int i = 0; i < array.length; i++){
			System.out.print(" " + array[i]);
		}
	}

	/**
	 * Binary search implementation.
	 *
	 * @param element which element to findIndex
	 * @return       index of searching element
	 */
	public int findIndex(int element){
		int top = nItems - 1;
		int bottom = 0;
		int index;

		while (true){
			index = (top + bottom) / 2;
			if(array[index] == element){
				return index;
			}else {
				if(element < array[index]){
					top = index - 1;
				}else {
					bottom = index + 1;
				}

			}
		}
	}

}
