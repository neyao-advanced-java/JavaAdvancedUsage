package org.oursight.neyao.java.advanced.concurrent.basic;

/**
 * Created by DellPC on 2017/3/20.
 */
public class StringClasses {

    public static void main(String[] args) {
        String s1 = "111";
        String s2 = new String("111");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s2 == s1);
    }
}
