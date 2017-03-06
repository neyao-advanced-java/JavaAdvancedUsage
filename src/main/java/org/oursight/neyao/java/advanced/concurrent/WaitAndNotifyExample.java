package org.oursight.neyao.java.advanced.concurrent;

import org.oursight.neyao.java.advanced.util.DateUtil;

/**
 * Created by DellPC on 2017/3/7.
 */
public class WaitAndNotifyExample {

    static boolean threadDone = false;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitingThread = new Thread(new Wait(), "Thread-Waiting");
        waitingThread.start();

        Thread.sleep(2000L);

        Thread notifyThread = new Thread(new Notify(), "Thread-Notify");
        notifyThread.start();
    }


    static  class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (!threadDone) {
                    try {
                        System.out.println(DateUtil.getCurrentDateTime() + " Waiting thread is waiting...");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(DateUtil.getCurrentDateTime() + " Waiting thread finish waiting and done");
                }
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                lock.notifyAll();
                threadDone = true;
                System.out.println(DateUtil.getCurrentDateTime() + " Notify get lock and notify all, will sleep 15 seconds");
                try {
                    Thread.sleep(15000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(DateUtil.getCurrentDateTime() + " Notify release lock");

                synchronized (lock) {
                    System.out.println(DateUtil.getCurrentDateTime() + " Notify get lock agian, will sleep for 10 seconds");
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
