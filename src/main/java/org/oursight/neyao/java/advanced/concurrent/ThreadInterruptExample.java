package org.oursight.neyao.java.advanced.concurrent;

/**
 * Created by neyao on 2017/3/2.
 */
public class ThreadInterruptExample {

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadInterruptExample().new ThreadToBeInterrupted());
        t.start();

        try {
            Thread.sleep(2000L);
            System.out.println("main about to interrupt Thread");
            t.interrupt();
            System.out.println("main about interrupt done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class ThreadToBeInterrupted implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Thread about to sleep for 20 seconds....");
                Thread.sleep(20000L);
                System.out.println("Thread woke up");
            } catch (InterruptedException e) {
                System.out.println("Thread sleeping was interrupted");
                e.printStackTrace();
            }

            System.out.println("Thread is done");
        }




    }
}


