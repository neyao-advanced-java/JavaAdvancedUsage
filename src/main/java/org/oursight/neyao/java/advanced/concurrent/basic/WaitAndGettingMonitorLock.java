package org.oursight.neyao.java.advanced.concurrent.basic;

/**
 * Created by DellPC on 2017/3/9.
 */
public class WaitAndGettingMonitorLock {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadInThisClass());

        System.out.println(Thread.currentThread().getName() + " start thread");
        System.out.println(Thread.currentThread().getName() + " 1 holdsLock of t1: " + Thread.currentThread().holdsLock(t1) + "; " + "t1.getState() 2: " + t1.getState());
        System.out.println("t1.getState() 1: " + t1.getState());

        synchronized (t1) {
            System.out.println();
            System.out.println();
            t1.start();

            System.out.println(Thread.currentThread().getName() + " 2 holdsLock of t1: " + Thread.currentThread().holdsLock(t1) + "; " + "t1.getState() 2: " + t1.getState());
            t1.wait();
            System.out.println(Thread.currentThread().getName() + " 3 holdsLock of t1: " + Thread.currentThread().holdsLock(t1) + "; " + "t1.getState() 2: " + t1.getState());
            System.out.println();
            System.out.println();
        }
        System.out.println(Thread.currentThread().getName() + " 4 holdsLock of t1: " + Thread.currentThread().holdsLock(t1) + "; " + "t1.getState() 2: " + t1.getState());
        System.out.println("t1.getState() 4: " + t1.getState());


        System.out.println(Thread.currentThread().getName() + " start thread done");
    }


    static class ThreadInThisClass implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " start...");
            System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + "  will begin waiting");
//            try {
//                synchronized (this) {
//                    wait();
//                }
//                System.out.println(Thread.currentThread().getName() + " done waiting");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + " will be done");

        }
    }
}
