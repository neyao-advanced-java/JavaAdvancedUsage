package org.oursight.neyao.java.advanced.gc;

import org.oursight.neyao.java.advanced.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neyao on 2017/3/16.
 */
public class CreateObjectsAndGc {

    private static final int _1MB = 1024 * 1024;
    private static final int _1KB = 1024;

    public static void main(String[] args) throws Exception {

        ShowGarbageCollectors.print();
        testAllocation();

    }

    /**
     * -XX:+UseSerialGC -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:d:/temp/gc.log
     */
    private static void testAllocation() throws InterruptedException {
        byte[] a1, a2, a3, a4, a5, a6;

        LogUtil.log("ready... ");
        Thread.sleep(15000L);
        LogUtil.log("go!!!");


        a1 = new byte[2 * _1MB];
        LogUtil.log("2MB allocated");
        Thread.sleep(3000L);

        a2 = new byte[2 * _1MB];
        LogUtil.log("2MB allocated");
        Thread.sleep(3000L);

        a3 = new byte[2 * _1MB];
        LogUtil.log("2MB allocated");
        Thread.sleep(3000L);

        a4 = new byte[4 * _1MB];
        LogUtil.log("4MB allocated");
        Thread.sleep(3000L);


        a5 = new byte[4 * _1MB];
        LogUtil.log("4MB allocated");
        Thread.sleep(3000L);


        a6 = new byte[4 * _1MB];
        LogUtil.log("4MB allocated");
        Thread.sleep(3000L);
    }

    private static void createObjectContinually() {
        int i = 0;
        boolean flag = true;
        while (flag) {
            try {
                i++;
                List<byte[]> list = new ArrayList<byte[]>();
                list.add(new byte[_1KB]);//每次增加一个1k大小的数组对象
                LogUtil.log(i + "k memory used");
                list = null;
                Thread.sleep(10L);

            } catch (Throwable e) {
                e.printStackTrace();
                flag = false;
                LogUtil.log("count=" + i);//记录运行的次数
            }
        }
    }
}
