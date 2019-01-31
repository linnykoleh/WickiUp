package com.linnik.wickiup.laakmann.aligor._1_arrays;


public class OrdArray {

    private int arr[] = new int[10];
    private int size = 0;

    public void insert(int value){
        int i;
        for(i = 0; i < size; i++){
            if(arr[i] > value){
                break;
            }
        }
        for(int k = size; k > i; k--){
            arr[k] = arr[k - 1];
        }
        arr[i] = value;
        size++;
    }

    public int find(long searValue){

        int topDiapozon = arr.length - 1;
        int downDiapozon = 0;
        int curIn;

        while(true){
            curIn = (topDiapozon + downDiapozon) / 2;
            if(arr[curIn] == searValue) {
                return curIn;
            }else if(downDiapozon > topDiapozon){
                  return size;
            }else{
                if(searValue < arr[curIn]){
                    topDiapozon = curIn - 1;
                }else{
                    downDiapozon = curIn + 1;
                }
            }
        }
    }

    public void delete(long value){
        int posit = 0;
        for(;posit < size; posit++){
            if(arr[posit] == value){
                break;
            }
        }
        for(;posit < size; posit++){
            arr[posit] = arr[posit + 1];
        }
    }

    public int getKeyMaxValue(){
        int maxK = 0;
        int maxV = arr[0];
        for(int i = 0; i < size; i++){
            if(arr[i] > maxV){
                maxK = i;
                maxV = arr[i];
            }
        }
        return maxK;
    }
}
