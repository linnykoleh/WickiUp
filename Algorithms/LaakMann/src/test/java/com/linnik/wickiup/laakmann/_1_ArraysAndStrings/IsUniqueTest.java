package com.linnik.wickiup.laakmann._1_ArraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

public class IsUniqueTest {

    private final IsUnique isUnique = new IsUnique();

    @Test
    public void testUnique() {
        final boolean actual = isUnique.isUniqueChars("qwerty");

        Assert.assertTrue(actual);
    }

    @Test
    public void testNotUnique1() {
        final boolean actual = isUnique.isUniqueChars("abcdefga");

        Assert.assertFalse(actual);
    }


    @Test
    public void testNotUnique2() {
        final boolean actual = isUnique.isUniqueChars("qwerty_qwerty");

        Assert.assertFalse(actual);
    }
}
