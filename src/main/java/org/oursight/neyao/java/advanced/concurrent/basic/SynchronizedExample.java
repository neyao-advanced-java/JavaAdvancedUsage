package org.oursight.neyao.java.advanced.concurrent.basic;

/**
 * Created by DellPC on 2017/3/7.
 */
public class SynchronizedExample {

    public static void main(String[] args) {
        synchronized (SynchronizedExample.class) {
            method();
        }
    }

    public static synchronized void method() {

    }
}
