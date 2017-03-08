package org.oursight.neyao.java.advanced.concurrent.executor;

import org.oursight.neyao.java.advanced.util.DateUtil;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by neyao on 2017/3/8.
 */
public class ThreadPoolExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("executorService: " + executorService);
        for (int i = 0; i < 10; i++) {
            Future future = executorService.submit(new Worker());
            System.out.println(DateUtil.getCurrentDateTime() + " executed " + i +"; future: " + future + "; " + future.get());


        }

    }

    static class Worker implements Runnable {
        @Override
        public void run() {

            System.out.println(DateUtil.getCurrentDateTime() + ": " + Thread.currentThread().getName()  + " started");
            try {
                Thread.sleep(1500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(DateUtil.getCurrentDateTime() + ": " + Thread.currentThread().getName()  + " done");
        }
    }
}
