package org.oursight.neyao.java.advanced.concurrent.basic;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by DellPC on 2017/3/6.
 */
public class ThreadMXBeanExample {

    public static void main(String[] args) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfo = bean.dumpAllThreads(false, false);
        for (ThreadInfo info : threadInfo) {
            System.out.println(info.getThreadId() +": " + info.getThreadName());
        }
    }
}
