package org.oursight.neyao.java.advanced.concurrent.basic;

/**
 * Created by DellPC on 2017/3/1.
 */
public class VolatileExample {

    public static void main(String[] args) {
        VolatileData data = new VolatileData();

        Thread t1 = new Thread(new Thread1(data));
        Thread t2 = new Thread(new Thread2(data));
        t1.start();
        t2.start();
    }

    class VolatileDataAsInnerClass {

        private int counter = 0;

        public int getCounter() {
            return counter;
        }

        public void addCounter() {
            ++counter;
        }
    }

}

class VolatileData {

    private static int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void addCounter() {
        ++counter;
    }
}


class Thread1 implements Runnable {

    private VolatileData data;

    public Thread1(VolatileData data) {
        this.data = data;
    }


    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            data.addCounter();
//            System.out.println(Thread.currentThread().getId() + ": data before sleep = " + data.getCounter());
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + ": data after sleep =  " + data.getCounter());

        }


    }
}

class Thread2 implements Runnable {

    private VolatileData data;

    public Thread2(VolatileData data) {
        this.data = data;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            data.addCounter();
//            System.out.println(Thread.currentThread().getId() + ": data before sleep = " + data.getCounter());
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + ": data after sleep = " + data.getCounter());

        }
    }
}