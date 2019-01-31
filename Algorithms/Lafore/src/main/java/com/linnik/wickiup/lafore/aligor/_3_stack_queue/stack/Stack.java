package com.linnik.wickiup.lafore.aligor._3_stack_queue.stack;


public class Stack {

    private int[] arr;
    private int top = 0;

    public Stack(int max){
        arr = new int[max];
    }

    public void push(int elem){
        arr[++top] = elem;
    }

    public int pop(){
        return arr[top--];
    }

    public int peek(){
        return arr[top];
    }

    public int getSize() {
        return top;
    }
}
