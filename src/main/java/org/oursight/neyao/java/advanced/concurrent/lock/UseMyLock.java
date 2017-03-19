package org.oursight.neyao.java.advanced.concurrent.lock;

import org.oursight.neyao.java.advanced.util.DateUtil;

/**
 * Created by DellPC on 2017/3/19.
 */
public class UseMyLock {

    public static void main(String[] args) {
        Thread t1 = new MyThread("MyThread-1");
        Thread t2 = new MyThread("MyThread-2");

        MyLock myLock = new MyLock();
        myLock.lock();

        t1.start();

        myLock.unlock();

        t2.start();
    }

    private static class MyThread extends Thread {



        public MyThread(String name) {
            Thread.currentThread().setName(name);
        }

        @Override
        public void run() {
            try {
                System.out.println();
                System.out.println();
                System.out.println(DateUtil.getCurrentDateTime() + " " + Thread.currentThread().getName() + " executed");
//                System.out.println(DateUtil.getCurrentDateTime() + " " + Thread.currentThread().getName() + " start sleeping");
                Thread.sleep(2000L);
//                System.out.println(DateUtil.getCurrentDateTime() + " " + Thread.currentThread().getName() + " finish sleeping");
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
