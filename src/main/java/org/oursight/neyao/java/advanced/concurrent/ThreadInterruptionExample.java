package org.oursight.neyao.java.advanced.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by neyao on 2017/3/6.
 */
public class ThreadInterruptionExample {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepThread(), "Thread-SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyThread(), "Thread-BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleepThread.isAlive() = " + sleepThread.isAlive());
        System.out.println("busyThread.isAlive() = " + busyThread.isAlive());
        System.out.println();
        System.out.println("sleepThread.isInterrupted() = " + sleepThread.isInterrupted());
        System.out.println("busyThread.isInterrupted() = " + busyThread.isInterrupted());
        System.out.println();
        System.out.println("sleepThread.isAlive() = " + sleepThread.isAlive());
        System.out.println("busyThread.isAlive() = " + busyThread.isAlive());

    }

    static class SleepThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyThread implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
