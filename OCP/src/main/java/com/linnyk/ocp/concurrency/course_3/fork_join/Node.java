package com.linnyk.ocp.concurrency.course_3.fork_join;

import java.util.ArrayList;
import java.util.Collection;

public class Node {

    private long value;
    private Collection<Node> children = new ArrayList<>();

    public Node(long value){
        this.value = value;
    }

    public Node(long value, Collection<Node> children){
        this.value = value;
        this.children = children;
    }

    public Collection<Node> getChildren(){
        return children;
    }

    public long getValue(){
        System.out.println("Start reading: " + value);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
        System.out.println("Finished reading: " + value);
        return this.value;
    }
}