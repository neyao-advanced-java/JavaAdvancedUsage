package org.oursight.neyao.java.advanced.concurrent.basic;

/**
 * Created by neyao on 2017/3/11.
 */
public class Reordering {
    
    static boolean ready;
    
    static int number;

    public static void main(String[] args) {
        new InternalThread().start();
        number = 42;
        ready = true;
    }
    
    static class InternalThread extends Thread {

        @Override
        public void run() {
            
            while (!ready) {
                Thread.yield();
            }

            // 可能会出现 number = 0 的情况，因为第14行和第15行可能会重排序
            System.out.println("number = " + number);
            
        }
    }
}
