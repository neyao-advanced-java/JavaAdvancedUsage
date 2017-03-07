package org.oursight.neyao.java.advanced.concurrent.basic;

import org.apache.commons.lang3.ObjectUtils;

/**
 * Created by DellPC on 2017/3/8.
 */
public class ThreadLocalExample {

    public static void main(String[] args) throws InterruptedException {
        Integer main_i1 = new Integer(10);
        Integer main_i2 = new Integer(90);

        System.out.println("main_i1 = " + System.identityHashCode(main_i1));
        System.out.println("main_i2 = " + System.identityHashCode(main_i2));

        Thread t1 = new Thread(new Thread1InThreadLocalExample(), "MyThread-1");
        Thread t2 = new Thread(new Thread1InThreadLocalExample(), "MyThread-2");
        t1.start();

        Thread.sleep(2000L);

        t2.start();

    }


}

class Thread1InThreadLocalExample implements Runnable {

    Integer thread_i3 = new Integer(90);

    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        begin();

        int thread_i1 = 10;
        Integer thread_i2 = new Integer(90);
//        System.out.println(Thread.currentThread().getName() + " i2: " + System.identityHashCode(thread_i2));
        System.out.println(Thread.currentThread().getName() + " i2 hex: " + ObjectUtils.identityToString(thread_i2));

        System.out.println(Thread.currentThread().getName() + " i3 hex: " + ObjectUtils.identityToString(thread_i3));


        end(); // 保存在本地变量中
    }

    public void begin() {
        threadLocal.set(System.currentTimeMillis());

    }

    public void end() {
        long delta = System.currentTimeMillis() - threadLocal.get();
        System.out.println(Thread.currentThread().getName() + " time cost = " + delta + " ms");
    }
}


