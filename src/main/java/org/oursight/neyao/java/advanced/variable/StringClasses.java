package org.oursight.neyao.java.advanced.variable;

/**
 * Created by DellPC on 2017/3/20.
 */
public class StringClasses {

    public static void main(String[] args) {

        // 用javap -verbose命令能够看到常量池的存放路径

        stringDemo();

        int i1 = 111111111;

//        String s1 = "111";
//        String s2 = new String("111");
//
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
//
//        System.out.println(s2 == s1);
    }

    private static void stringDemo() {

        // see: http://www.cnblogs.com/iyangyuan/p/4631696.html
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s6 = s5.intern();
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // true
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s9);  // false
        System.out.println(s4 == s5);  // false
        System.out.println(s1 == s6);  // true
        System.out.println(s1 == s6);  // true
    }
}
