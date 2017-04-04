package org.oursight.neyao.java.advanced.util;

/**
 * Created by DellPC on 2017/3/19.
 */
public class LogUtil {

    public static long log(String message) {
        System.out.println(DateUtil.getCurrentDateTime() + "  " + message);
        return System.nanoTime();
    }


    public static long log(String message, long startTime) {
        long current = System.nanoTime();
        long timeCost = current - startTime;
        System.out.println(DateUtil.getCurrentDateTime() + "  " + message + ". Time cost: " + timeCost + " ns (" + timeCost / 1000000 + "ms)");
        return current;
    }
}
