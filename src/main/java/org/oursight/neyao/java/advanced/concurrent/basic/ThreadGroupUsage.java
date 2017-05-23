package org.oursight.neyao.java.advanced.concurrent.basic;

/**
 * Created by neyao on 2017/5/23.
 */
public class ThreadGroupUsage {

    /**
     * 线程总是线程组的成员。
     * 默认情况下，线程的线程组是其创建者线程的组。
     * Java程序中的线程组由java.lang.ThreadGroup类的一个对象表示。
     * Thread类中的getThreadGroup()方法返回一个线程的ThreadGroup的引用。
     * 例子
     * <p>
     * 以下代码演示了，默认情况下，新线程是其创建者线程的线程组的成员。
     */
    public static void main(String[] args) {
        Thread t1 = Thread.currentThread();

        ThreadGroup tg1 = t1.getThreadGroup();

        System.out.println("Current thread's  name:  " + t1.getName());
        System.out.println("Current thread's  group  name:  " + tg1.getName());

        Thread t2 = new Thread("my  new thread");

        ThreadGroup tg2 = t2.getThreadGroup();
        System.out.println("New  thread's name:  " + t2.getName());
        System.out.println("New  thread's  group  name:  " + tg2.getName());
    }
}
