package com.linnik.wickiup.patterns._1_creational._3_prototype.live;

import java.util.ArrayList;

/**
 * @author LinnykOleh
 */
public class Live {

    /**
     * Returns a shallow copy of this <tt>ArrayList</tt> instance.
     *
     *     public Object clone() {
     *          try {
     *              ArrayList<?> v = (ArrayList<?>) super.clone();
     *              v.elementData = Arrays.copyOf(elementData, size);
     *              v.modCount = 0;
     *              return v;
     *          } catch (CloneNotSupportedException e) {
     *              throw new InternalError(e);
     *          }
     *      }
     * </code>
     */
    public static void main(String[] args) {
        final ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("!!!");

        System.out.println(list); //[hello, world, !!!]

        final ArrayList<String> clonedList = (ArrayList<String>) list.clone();
        System.out.println(clonedList); //[hello, world, !!!]

        System.out.println(list != clonedList); //true
    }
}
