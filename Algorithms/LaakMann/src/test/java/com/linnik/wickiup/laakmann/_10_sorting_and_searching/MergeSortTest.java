package com.linnik.wickiup.laakmann._10_sorting_and_searching;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void test() {
        int[] actual = {10, 1, 5, 6, 3, 8, 19, 2, 7};

        new MergeSort().sort(actual);

        int[] expected = {1, 2, 3, 5, 6, 7, 8, 10, 19};

        Assert.assertArrayEquals(expected, actual);
    }

}
