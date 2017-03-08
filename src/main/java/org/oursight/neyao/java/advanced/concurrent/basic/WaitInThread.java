package org.oursight.neyao.java.advanced.concurrent.basic;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/**
 * Created by DellPC on 2017/3/9.
 */
public class WaitInThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadInThisClass());

        System.out.println(Thread.currentThread().getName() + " start thread");
        t1.start();

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
//        ThreadInfo[] dump = bean.getT.dumpAllThreads(true, true);
//        ThreadInfo threadInfoOfT1 = getThreadInfo(t1.getId(), dump);
        ThreadInfo threadInfoOfT1 = bean.getThreadInfo(t1.getId());

        System.out.println("threadInfoOfT1: " + threadInfoOfT1);

        System.out.println("threadInfoOfT1: " + threadInfoOfT1.getLockInfo());
        System.out.println("threadInfoOfT1: " + Arrays.toString(threadInfoOfT1.getLockedMonitors()));
        System.out.println("t1.getState() 1: " + t1.getState());
        synchronized (t1) {
//            System.out.println("t1.getState() 2: " + t1.getState());
            t1.wait();
//            System.out.println("t1.getState() 3: " + t1.getState());
        }
        System.out.println("t1.getState() 4: " + t1.getState());


        System.out.println(Thread.currentThread().getName() + " start thread done");
    }

    static ThreadInfo getThreadInfo(long threadId, ThreadInfo[] dump) {
        for (ThreadInfo threadInfo : dump) {
            if(threadInfo.getThreadId() == threadId) {
                return threadInfo;
            }
        }

        return null;
    }

    static class ThreadInThisClass implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " start...");
            System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " begin waiting");
//            try {
//                synchronized (this) {
//                    wait();
//                }
//                System.out.println(Thread.currentThread().getName() + " done waiting");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + " is done");

        }
    }
}
