package com.linnik.wickiup.lafore.data_structures.hash_tables.open_addressing.double_hashing;

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
        System.out.println("Table: ");
        for(int i = 0; i < arraySize; i++){
            if(hashArray[i] != null){
                System.out.println(hashArray[i].getKey() + " ");
            }else{
                System.out.println("** ");
            }
        }
        System.out.println("");
    }

    private int hashFunc1(int key){
        return key % arraySize;
    }

    private int hashFunc2(int key){
        // Возвращаемое значение отлично от нуля, меньше размера массива,
        // функция отлична от хеш-функции 1
        // Размер массива должен быть простым по отношению к 5, 4, 3 и 2
        return 5 - key % 5;
    }

    public void insert(int key){

        int hashVal = hashFunc1(key);   //Хеширование ключа
        int stepSize = hashFunc2(key);  //Вычисление смещения

        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = new DataItem(key);
    }

    public DataItem delete(int key){

        int hashVal = hashFunc1(key);   //Хеширование ключа
        int stepSize = hashFunc2(key);  //Вычисление смещения

        while (hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                DataItem tmp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return tmp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key){

        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
