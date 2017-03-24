package lafore.data_structures.hash_tables.open_addressing.linear_probing;

/**
 * @author LinnykOleh
 */
public class HashTable {

	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;

	public HashTable(int arraySize) {
		this.arraySize = arraySize;
		this.hashArray = new DataItem[arraySize];
		this.nonItem = new DataItem(-1);
	}

	public void displayTable(){
		for(int i = 0; i < hashArray.length; i++){
			if(hashArray[i] != null){
				System.out.println(hashArray[i].getKey() + " ");
			}else{
				System.out.println("** ");
			}
		}
		System.out.println("");
	}

	private int hashFunc(int key){
		return key % arraySize;
	}

	public void insert(DataItem item){
		int key = item.getKey();     // Получение ключа
		int hashVal = hashFunc(key); // Хеширование ключа

		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != nonItem.getKey()){ // Пока не будет найдена пустая ячейка или -1
			++hashVal;               // Переход к следующей ячейке
			hashVal %= arraySize;    // При достижении конца таблицы происходит возврат к началу
		}
		hashArray[hashVal] = item;   // Вставка элемента
	}

	public DataItem delete(int key){
		int hashVal = hashFunc(key);          // Хеширование ключа

		while(hashArray[hashVal] != null){   // Пока не будет найдена пустая ячейка
			if(hashArray[hashVal].getKey() == key){
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;
	}
}
