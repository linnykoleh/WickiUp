package com.linnik.wickiup.laakmann._1_arrays_and_strings;

import org.junit.Assert;
import org.junit.Test;

public class URLifyTest {

    private URLify urLify = new URLify();

    @Test
    public void test() {
        String expected = "Mr%20Scrub";

        String actual = urLify.replaceSpaces("Mr   Scrub");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        String expected = "Mr%20Scrub";

        String actual = urLify.replaceSpaces("  Mr   Scrub  ");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String expected = "Mr%20Scrub%20Smith%20100";

        String actual = urLify.replaceSpaces("Mr   Scrub  Smith 100");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String expected = "Mr%20Scrub";

        final String actual = urLify.replace("Mr Scrub".toCharArray());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String expected = "Mr%20Scrub%20Smith%20100";

        final String actual = urLify.replace("Mr  Scrub    Smith    100".toCharArray());

        Assert.assertEquals(expected, actual);
    }

}
