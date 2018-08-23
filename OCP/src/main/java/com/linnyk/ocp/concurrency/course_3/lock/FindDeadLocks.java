package com.linnyk.ocp.concurrency.course_3.lock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class FindDeadLocks {

    public static void main(String[] args) {

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(deadlockedThreads);
        for (ThreadInfo info : threadInfo) {
            System.out.println(info);
        }
    }
}
