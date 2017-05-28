package org.oursight.neyao.java.advanced.google.guava;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * Created by neyao on 2017/5/24.
 */
public class StopwatchUsage {

    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        for (int i = 0; i < 1000; i++) {

        }

        System.out.println(stopwatch);
        System.out.println(stopwatch.isRunning());
//        System.out.println(stopwatch.elapsed(TimeUnit));
    }
}
