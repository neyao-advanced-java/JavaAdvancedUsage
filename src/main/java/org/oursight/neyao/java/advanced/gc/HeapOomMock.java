package org.oursight.neyao.java.advanced.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neyao on 2017/3/16.
 */
public class HeapOomMock {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<byte[]>();
        int i = 0;
        boolean flag = true;
        while (flag){
            try {
                i++;
                list.add(new byte[1024 * 1024]);//每次增加一个1M大小的数组对象
                System.out.println(i + "M memory used");
                Thread.sleep(500L);

            }catch (Throwable e){
                e.printStackTrace();
                flag = false;
                System.out.println("count="+i);//记录运行的次数
            }
        }
    }
}
