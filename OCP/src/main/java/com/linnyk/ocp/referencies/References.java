package com.linnyk.ocp.referencies;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class References {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object(); //Strong reference
        WeakReference<Object> weakReference = new WeakReference<>(o); //Weak reference
        SoftReference<Object> softReference = new SoftReference<>(o); //Soft reference

        ReferenceQueue<Object> q = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o, q); //Phantom reference

        o = null;

        System.out.println(softReference.get());   // java.lang.Object@266474c2
        System.out.println(weakReference.get());   // java.lang.Object@266474c2
        System.out.println(phantomReference.get());// null

        System.gc();
        System.out.println("------------------");

        System.out.println(softReference.get());   // java.lang.Object@266474c2
        System.out.println(weakReference.get());   // null
        System.out.println(phantomReference.get());// null

        q.remove(); // Программа зависнет будет ждать, пока не удалиться o
    }
}
