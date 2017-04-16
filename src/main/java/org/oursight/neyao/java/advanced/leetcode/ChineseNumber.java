package org.oursight.neyao.java.advanced.leetcode;

/**
 * Created by DellPC on 2017/4/16.
 */
public class ChineseNumber {

    public static void main(String[] args) {
//        int i = 98765;
        int i = 98765;
        String s = i / 10000 + "万" + i / 1000 + "千" + i / 100 + "百" + i / 10 + "" + i / 1;

        System.out.println(s);
    }

}
