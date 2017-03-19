package org.oursight.neyao.java.advanced.util;

/**
 * Created by DellPC on 2017/3/19.
 */
public class LogUtil {

    public static long log(String message) {
        System.out.println(DateUtil.getCurrentDateTime() + "  " + message);
        return System.currentTimeMillis();
    }


    public static long log(String message, long startTime) {
        long timeCost = System.currentTimeMillis() - startTime;
        System.out.println(DateUtil.getCurrentDateTime() + "  " + message + ". Time cost: " + timeCost +" ms");
        return timeCost;
    }
}
