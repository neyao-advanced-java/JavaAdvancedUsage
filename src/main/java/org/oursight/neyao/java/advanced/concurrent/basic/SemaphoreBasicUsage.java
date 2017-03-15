package org.oursight.neyao.java.advanced.concurrent.basic;

import org.oursight.neyao.java.advanced.util.DateUtil;

import java.util.concurrent.Semaphore;

/**
 * Created by neyao on 2017/3/15.
 */
public class SemaphoreBasicUsage {

    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for (int i = 0; i < N; i++)
            new Worker(i, semaphore).start();
    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {

                System.out.println(DateUtil.getCurrentDateTime() + " 工人" + this.num + "准备获取机器...");
                semaphore.acquire();
                System.out.println(DateUtil.getCurrentDateTime() + "工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println(DateUtil.getCurrentDateTime() + "工人" + this.num + "释放出机器");

                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
