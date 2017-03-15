package org.oursight.neyao.java.advanced.concurrent.basic;

import java.util.concurrent.CountDownLatch;

/**
 * see: http://www.importnew.com/21889.html
 * Created by neyao on 2017/3/14.
 */
public class CountDownLatchBasicUsage {

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(2);

        System.out.println("主线程开始执行...");


        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行完成...");

    }
}
