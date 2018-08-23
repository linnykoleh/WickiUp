package com.linnik.wickiup.lafore.aligor._4_quick_sort._4_1_partition;


public class MainPartition {

    public static void main(String[] args) {

        final int size = 10;

        final ArrayPart arrayPart = new ArrayPart(size);

        arrayPart.insert(5);
        arrayPart.insert(6);
        arrayPart.insert(34);
        arrayPart.insert(2);
        arrayPart.insert(36);
        arrayPart.insert(72);
        arrayPart.insert(7);
        arrayPart.insert(1);
        arrayPart.insert(0);
        arrayPart.insert(50);

        arrayPart.show();

        arrayPart.partitionIt(20);

        arrayPart.show();
    }
}
