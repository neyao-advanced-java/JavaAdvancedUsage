package org.oursight.neyao.java.advanced.variable;

/**
 * Created by neyao on 2017/3/21.
 */
public class JavaVariables {

    public static void main(String[] args) {
        byte b = 100;
        System.out.println(b);

        Byte bb = new Byte("1");
        System.out.println("bb = " + bb.byteValue());

        char c = '中';
//        System.out.println(c.getBytes().l);

        String s = "中";
        System.out.println(s.getBytes().length);
        System.out.println(s.toCharArray().length);
    }
}
