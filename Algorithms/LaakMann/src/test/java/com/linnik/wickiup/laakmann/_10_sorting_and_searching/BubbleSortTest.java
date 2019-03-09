package com.linnik.wickiup.laakmann._10_sorting_and_searching;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void test() {
        int[] actual = {10, 1, 5, 6, 3, 8};

        new BubbleSort().sort(actual);

        int[] expected = {1, 3, 5, 6, 8, 10};

        Assert.assertArrayEquals(expected, actual);
    }
}
