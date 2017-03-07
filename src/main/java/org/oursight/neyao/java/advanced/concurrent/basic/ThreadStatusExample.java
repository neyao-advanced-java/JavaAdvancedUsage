package org.oursight.neyao.java.advanced.concurrent.basic;

/**
 * Created by neyao on 2017/3/6.
 */
public class ThreadStatusExample {

    public static void main(String[] args) {

        new Thread(new TimeWaitingThread(), "TimeWaitingThread").start();
        new Thread(new WaitingThread(), "WaitingThread").start();
        new Thread(new BlockedThread(), "BlockedThread-1").start();
        new Thread(new BlockedThread(), "BlockedThread-2").start();

    }

    static class TimeWaitingThread implements Runnable {

        @Override
        public void run() {

            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class WaitingThread implements Runnable {

        @Override
        public void run() {
            while(true) {
                synchronized (WaitingThread.class) {
                    try {
                        WaitingThread.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class BlockedThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (BlockedThread.class) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
