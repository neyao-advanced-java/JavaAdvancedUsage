package org.oursight.neyao.java.advanced.concurrent.basic;

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

        System.out.println("------ before -------");

        System.out.println("sleepThread.isInterrupted() 1 = " + sleepThread.isInterrupted());
        System.out.println("busyThread.isInterrupted() 1 = " + busyThread.isInterrupted());
        System.out.println();
        System.out.println();


        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("------ after -------");

        System.out.println("sleepThread.isAlive() = " + sleepThread.isAlive());
        System.out.println("busyThread.isAlive() = " + busyThread.isAlive());
        System.out.println();
        System.out.println("sleepThread.isInterrupted() 2 = " + sleepThread.isInterrupted());
        System.out.println("busyThread.isInterrupted() 2 = " + busyThread.isInterrupted());
        System.out.println();
        System.out.println("sleepThread.isAlive() = " + sleepThread.isAlive());
        System.out.println("busyThread.isAlive() = " + busyThread.isAlive());
        System.out.println();
        System.out.println("sleepThread.isInterrupted() 3 = " + sleepThread.isInterrupted());
        System.out.println("busyThread.isInterrupted() 3 = " + busyThread.isInterrupted());
        System.out.println();

    }

    static class SleepThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000L);
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
