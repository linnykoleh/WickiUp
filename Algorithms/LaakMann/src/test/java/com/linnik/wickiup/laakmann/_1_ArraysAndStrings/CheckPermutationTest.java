package com.linnik.wickiup.laakmann._1_ArraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class CheckPermutationTest {

    private final CheckPermutation checkPermutation = new CheckPermutation();

    //========================================
    //Tests for solution 1
    //========================================
    @Test
    public void testPermutationSolution1() {
        String st1 = "dog";
        String st2 = "god";

        final boolean actual = checkPermutation.permutation1(st1, st2);

        Assert.assertTrue(actual);
    }

    @Test
    public void testNotPermutation1Solution1() {
        String st1 = "doggy";
        String st2 = "god";

        final boolean actual = checkPermutation.permutation1(st1, st2);

        Assert.assertFalse(actual);
    }

    @Test
    public void testNotPermutation2Solution1() {
        String st1 = "bog";
        String st2 = "god";

        final boolean actual = checkPermutation.permutation1(st1, st2);

        Assert.assertFalse(actual);
    }

    //========================================
    //Tests for solution 2
    //========================================
    @Test
    public void testPermutationSolution2() {
        String st1 = "dog";
        String st2 = "god";

        final boolean actual = checkPermutation.permutation2(st1, st2);

        Assert.assertTrue(actual);
    }

    @Test
    public void testNotPermutation1Solution2() {
        String st1 = "doggy";
        String st2 = "god";

        final boolean actual = checkPermutation.permutation2(st1, st2);

        Assert.assertFalse(actual);
    }

    @Test
    public void testNotPermutation2Solution2() {
        String st1 = "bog";
        String st2 = "god";

        final boolean actual = checkPermutation.permutation2(st1, st2);

        Assert.assertFalse(actual);
    }

    @Test
    public void testNotPermutation3Solution2() {
        String st1 = "dogg";
        String st2 = "goda";

        final boolean actual = checkPermutation.permutation2(st1, st2);

        Assert.assertFalse(actual);
    }


}
