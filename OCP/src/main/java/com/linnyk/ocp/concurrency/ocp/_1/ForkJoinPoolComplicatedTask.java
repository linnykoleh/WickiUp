package com.linnyk.ocp.concurrency.ocp._1;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolComplicatedTask extends RecursiveAction {

    int[] ia; int from; int to;

    public ForkJoinPoolComplicatedTask(int[] ia, int from, int to){
        this.ia = ia;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void compute() {
        if(from == to){
            //Update the value using logic implemented somewhere else.             
            ia[from] = UtilityClass.utilityMethod(ia[from]);
        }else{
            int mid = (from + to) / 2;
            ForkJoinPoolComplicatedTask newtask1 = new ForkJoinPoolComplicatedTask(ia, from, mid);
            ForkJoinPoolComplicatedTask newtask2 = new ForkJoinPoolComplicatedTask(ia, mid+1, to);
            newtask2.fork();
            newtask1.compute();
            newtask2.join();
        }
    }

    public static void main(String[] args) {
        int ia[] = new int[]{ 1, 2, 3, 4 , 5, 6, 7};
        ForkJoinPool fjp = new ForkJoinPool();
        ForkJoinPoolComplicatedTask st = new ForkJoinPoolComplicatedTask(ia, 0, 6);
        fjp.invoke(st);
        System.out.print("New Array Values = ");
        for(int i : ia) {
            System.out.print(i + " ");  //  2 3 4 5 6 7 8
        }
    }

}

class UtilityClass{

    public static int utilityMethod(int x) {
        return x + 1;
    }
}
