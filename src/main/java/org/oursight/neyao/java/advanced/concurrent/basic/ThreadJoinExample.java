package org.oursight.neyao.java.advanced.concurrent.basic;

/**
 * Created by DellPC on 2017/3/9.
 */
public class ThreadJoinExample {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Thread1(), "Thread-t1");
        Thread t2 = new Thread(new Thread1(), "Thread-t2");
        Thread t3 = new Thread(new Thread1(), "Thread-t3");

        System.out.println(Thread.currentThread().getName() + " start...");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(Thread.currentThread().getName() + " done");
    }

    static class Thread1 implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start...");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " done");

        }
    }
}
