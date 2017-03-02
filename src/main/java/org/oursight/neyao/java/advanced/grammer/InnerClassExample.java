package org.oursight.neyao.java.advanced.grammer;

/**
 * Created by neyao on 2017/3/2.
 */
public class InnerClassExample {

    public static void main(String[] args) {
        // You should create instance of inner class like this
        ThreadToBeInterrupted t1 = new InnerClassExample().new ThreadToBeInterrupted();

        // You can not init a inner class like this in a static method
//        ThreadToBeInterrupted t2 = new ThreadToBeInterrupted();

    }

    public void init() {
        ThreadToBeInterrupted t2 = new ThreadToBeInterrupted();
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


