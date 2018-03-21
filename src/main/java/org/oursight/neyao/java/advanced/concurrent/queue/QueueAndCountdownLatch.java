package org.oursight.neyao.java.advanced.concurrent.queue;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by yaonengjun on 2018/3/21 下午5:59.
 */
public class QueueAndCountdownLatch {

//  private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

  private Map<String, BlockingQueue<String>> queues = new ConcurrentHashMap<>();

  private CountDownLatch countDownLatch;

  private ExecutorService threadPool = Executors.newCachedThreadPool();
//  private ExecutorService threadPool = Executors.newFixedThreadPool(1);

  private void init() {


    BlockingQueue<String> queue1 = new LinkedBlockingQueue<>();
    for (Integer i = 0; i < 100; i++) {
      queue1.offer(i.toString());
    }
    BlockingQueue<String> queue2 = new LinkedBlockingQueue<>();
    for (char c = 'a'; c < 'z'; c++) {
      queue2.offer(c + "");
    }
    queues.put("20180320", queue1);
    queues.put("20180321", queue2);


    countDownLatch = new CountDownLatch(queue1.size() + queue2.size());

    for (int i = 1; i <= 3; i++) {
//      threadPool.submit(new BlockedWorker());
      threadPool.submit(new NonBlockedWorker("20180320"));
      // 这两个Worker的行为是不一样的， BlockedWorkder执行完以后线程还在，NonBlockedWorker执行完以后线程就不存在了
    }

    threadPool.submit(new NonBlockedWorker("20180321"));

    Uninterruptibles.awaitUninterruptibly(countDownLatch);

    System.out.println();
    System.out.println();
    System.out.println("======> ALL DONE");
  }


  private class BlockedWorker implements Runnable {

    private String key;

    public BlockedWorker(String key) {
      this.key = key;
    }

    @Override
    public void run() {
      // 修改thread的名字
      Thread.currentThread().setName(key + "-" + Thread.currentThread().getName());
      while (true) {
        try {
          String i = queues.get(key).take();
          countDownLatch.countDown();
          System.out.println(Thread.currentThread().getName() + ": " + i + ", counting: " + countDownLatch.getCount() + ", queue size: " + queues.get(key).size());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    }
  }


  private class NonBlockedWorker implements Runnable {

    private String key;

    public NonBlockedWorker(String key) {
      this.key = key;
    }

    @Override
    public void run() {
      // 修改thread的名字
      Thread.currentThread().setName(key + "-" + Thread.currentThread().getName());
      while (queues.get(key).peek() != null) {
        try {
          BlockingQueue<String> queue = queues.get(key);
          String i = queue.poll();
          if (i == null) {
            continue;
          }
          countDownLatch.countDown();
          System.out.println(Thread.currentThread().getName() + ": " + i + ", counting: " + countDownLatch.getCount() + ", queue size: " + queue.size());
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }
  }


  public static void main(String[] args) {
    QueueAndCountdownLatch q = new QueueAndCountdownLatch();
    q.init();
  }

}


