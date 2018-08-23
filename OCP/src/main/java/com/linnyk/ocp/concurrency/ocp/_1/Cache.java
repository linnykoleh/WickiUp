package com.linnyk.ocp.concurrency.ocp._1;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

    static ConcurrentHashMap<String, Object> chm = new ConcurrentHashMap<String, Object>();

    public static void main(String[] args) {
        chm.put("a", "aaa");
        chm.put("b", "bbb");
        chm.put("c", "ccc");

        new Thread(){
            public void run(){
                Iterator<Map.Entry<String, Object>> it = Cache.chm.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry<String, Object> en = it.next();
                    if(en.getKey().equals("a") || en.getKey().equals("b")){
                        final String key = en.getKey();
                        it.remove();
                        System.out.println("Removed " + key);
                    }
                }
            }
        }.start();

        new Thread(){
            public void run(){
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) { }
                Iterator<Map.Entry<String, Object>> it = Cache.chm.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry<String, Object> en = it.next();
                    System.out.print("Printed " + en.getKey()+", ");
                }
            }
        }.start();
    }
}


