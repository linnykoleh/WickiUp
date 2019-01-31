package com.linnik.wickiup.laakmann.data_structures.stack;

/**
 * @author LinnykOleh
 */
public class Stack<Type> {

    private Object[] array;
    private int size;
    private int top;

    public Stack(int size) {
        this.size = size;
        this.array = new Object[size];
    }

    public void push(Type value){
        if(top < size){
            array[top++] = value;
        }else{
            System.out.format("Can't insert %s bcs stack is full \n", value);
        }
    }

    public Type pop(){
        Type value = (Type) array[--top];
        array[top] = null;
        return value;
    }

    public Type peek(){
        return (Type) array[top-1];
    }

    public boolean isEmpty(){
        return top == 0;
    }

}
