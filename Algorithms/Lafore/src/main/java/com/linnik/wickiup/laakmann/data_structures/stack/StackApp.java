package com.linnik.wickiup.laakmann.data_structures.stack;

import org.junit.Test;

/**
 * @author LinnykOleh
 */
public class StackApp {

    @Test
    public void testIntegerStack() {
        final Stack<Integer> stack = new Stack<>(10);

        stack.push(5);
        stack.push(12);
        stack.push(16);
        stack.push(1);
        stack.push(3);
        stack.push(8);
        stack.push(9);

        System.out.println(stack.pop());   // 9
        System.out.println(stack.peek());  // 8
        System.out.println(stack.pop());   // 8
        System.out.println(stack.peek());  // 3
        System.out.println(stack.pop());   // 3
        System.out.println(stack.peek());  // 1
    }

    @Test
    public void testReverseStringUsingStack() {
        final String word = "Hello, world!";

        final Stack<Character> stack = new Stack<>(word.length());

        final char[] wordArray = word.toCharArray();

        for(char letter : wordArray){
            stack.push(letter);
        }

        System.out.println(word);          //Hello, world!

        while (!stack.isEmpty()){
            System.out.print(stack.pop()); //!dlrow ,olleH
        }
    }

}
