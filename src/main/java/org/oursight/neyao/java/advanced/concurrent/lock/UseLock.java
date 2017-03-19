package org.oursight.neyao.java.advanced.concurrent.lock;

import org.oursight.neyao.java.advanced.util.DateUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DellPC on 2017/3/19.
 */
public class UseLock {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new MyThread("MyThread-1", lock);
        Thread t2 = new MyThread("MyThread-2", lock);

        t1.start();
        t2.start();
    }

    private static class MyThread extends Thread {

        private Lock lock;

        public MyThread(String name, Lock lock) {
            setName(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            try {

                lock.lock();

                System.out.println();
                System.out.println();
                System.out.println(DateUtil.getCurrentDateTime() + " " + Thread.currentThread().getName() + " executed");
//                System.out.println(DateUtil.getCurrentDateTime() + " " + Thread.currentThread().getName() + " start sleeping");
                Thread.sleep(2000L);
//                System.out.println(DateUtil.getCurrentDateTime() + " " + Thread.currentThread().getName() + " finish sleeping");
                System.out.println();
                System.out.println();

                lock.unlock();

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
