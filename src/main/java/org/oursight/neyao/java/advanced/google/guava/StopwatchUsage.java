package org.oursight.neyao.java.advanced.google.guava;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * Created by neyao on 2017/5/24.
 */
public class StopwatchUsage {

    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        System.out.println();
//        System.out.println(stopwatch.(TimeUnit.MILLISECONDS));
        Thread.sleep(1000L);

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        System.out.println();
        Thread.sleep(2000L);

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        System.out.println();

//        for (int i = 0; i < 1000; i++) {
//
//        }

        System.out.println(stopwatch);
        System.out.println(stopwatch.isRunning());
//        System.out.println(stopwatch.elapsed(TimeUnit));
    }
}
