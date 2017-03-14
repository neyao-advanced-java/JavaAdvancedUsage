package org.oursight.neyao.java.advanced.concurrent.basic;

import org.oursight.neyao.java.advanced.util.DateUtil;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 本例子说明了CyclicBarrier的作用，以及演示了可重用的过程
 * see: http://www.importnew.com/21889.html
 *
 * Created by neyao on 2017/3/14.
 */
public class CyclicBarrierBasicUsage {

    public static void main(String[] args) {

        System.out.println(DateUtil.getCurrentDateTime() + " 主线程开始执行");

        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }

        try {
            System.out.println();
            System.out.println("第一轮线程执行完成...");
            System.out.println();

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println("重用CyclicBarrier进行第二轮线程的执行...");
        System.out.println();
        System.out.println();

        for(int i=0;i<N;i++) {
            new Writer(barrier).start();
        }

        System.out.println(DateUtil.getCurrentDateTime() + " 主线程执行完成");
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(DateUtil.getCurrentDateTime() + " 线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);      //以睡眠来模拟写入数据操作
                System.out.println(DateUtil.getCurrentDateTime() + " 线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(DateUtil.getCurrentDateTime() + " 所有线程写入完毕，继续处理其他任务... （printed from " + Thread.currentThread().getName() + "）");
        }
    }
}
