package org.oursight.neyao.java.advanced.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neyao on 2017/3/16.
 */
public class CreateObjectsAndGc {

    private static final int _1MB = 1024*1024;
    private static final int _1KB = 1024;

    public static void main(String[] args) {

        ShowGarbageCollectors.print();


    }

    private static void createObjectContinually() {
        int i = 0;
        boolean flag = true;
        while (flag) {
            try {
                i++;
                List<byte[]> list = new ArrayList<byte[]>();
                list.add(new byte[_1KB]);//每次增加一个1k大小的数组对象
                System.out.println(i + "k memory used");
                list = null;
                Thread.sleep(10L);

            } catch (Throwable e) {
                e.printStackTrace();
                flag = false;
                System.out.println("count=" + i);//记录运行的次数
            }
        }
    }
}
