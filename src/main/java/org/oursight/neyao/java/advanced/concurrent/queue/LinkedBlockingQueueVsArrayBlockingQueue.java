package org.oursight.neyao.java.advanced.concurrent.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 这个例子说明， 在没有并发的情况下，ArrayBlockingQueue的读写性能比LinkedBLockingQueue要好
 * Created by neyao on 2017/3/8.
 */
public class LinkedBlockingQueueVsArrayBlockingQueue {

    static BlockingQueue arrayBlockingQueue;
    static BlockingQueue linkedBlockingQueue;

    static int SIZE = 20000000;

    public static void main(String[] args) throws InterruptedException {
        arrayBlockingQueue = new ArrayBlockingQueue(SIZE);
        linkedBlockingQueue = new LinkedBlockingQueue<>();

        System.out.println(Integer.MAX_VALUE);

        Thread producer1 = new Thread(new AsyncProducer(arrayBlockingQueue));
        producer1.start();

        Thread.sleep(10000L);

        Thread consumer1 = new Thread(new AsyncConsumer(arrayBlockingQueue));
        consumer1.start();

        Thread.sleep(10000L);

        Thread producer2 = new Thread(new AsyncProducer(linkedBlockingQueue));
        producer2.start();

        Thread.sleep(10000L);

        Thread consumer2 = new Thread(new AsyncConsumer(linkedBlockingQueue));
        consumer2.start();
    }


    static class AsyncProducer implements Runnable {
        private Queue queue;

        AsyncProducer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            long t1 = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                queue.offer(i);
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            }

            long t2 = System.currentTimeMillis();
            System.out.println("Queue: " + queue.getClass() + ", AsyncProducer done, time cost: " + (t2 - t1) + " ms");
        }
    }

    static class AsyncConsumer implements Runnable {
        private Queue queue;

        AsyncConsumer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            long t1 = System.currentTimeMillis();
            while (queue.peek() != null) {
                queue.poll();
                // System.out.println(queue.poll());
            }

            long t2 = System.currentTimeMillis();
            System.out.println("Queue: " + queue.getClass() + ", AsyncConsumer done, time cost: " + (t2 - t1) + " ms");
        }
    }

}
